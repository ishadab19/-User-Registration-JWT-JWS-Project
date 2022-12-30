package com.bridgelabz.userregistration.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    private static final String TOKEN_SECRET = "Shadab";

    public String createToken(int userId) {
        try {
            //to set Algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            String token = JWT.create()
                    .withClaim("user_iD", userId)
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            // log Token signing  Failed
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long decodeToken(String token) {
        Long user_Id;
        //For verification algo
        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        JWTVerifier jwtVerifier = verification.build();
        //to decode token
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Claim claim = decodedJWT.getClaim("user_Id");
        user_Id = claim.asLong();
        return user_Id;
    }

}
