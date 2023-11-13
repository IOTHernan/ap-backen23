package com.apbackend23.crud.security.jwt;

import com.apbackend23.crud.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.Jwts.*;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public <a> String getNombreUsuarioFromToken(String token){
        //return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        private a = parseClaimsJws(token);
        return parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            //parser().setSigningKey(secret).parseClaimsJws(token);
            //parser().setSigningKey(secret).parseClaimsJws(token);

            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacío");
        }catch (SignatureException e){
            logger.error("fail en la firma");
        }
        return false;
    }
}
