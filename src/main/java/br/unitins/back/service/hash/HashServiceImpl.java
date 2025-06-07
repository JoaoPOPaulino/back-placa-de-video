package br.unitins.back.service.hash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HashServiceImpl implements HashService {

    private String salt = "#blahxyz17";

    private Integer iterationCount = 405;

    private Integer keyLength = 512;

    @Override
    public String getHashSenha(String senha) {

        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(new PBEKeySpec(senha.toCharArray(),
                            salt.getBytes(), iterationCount, keyLength))
                    .getEncoded();

            return Base64.getEncoder().encodeToString(result);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar um hash");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashService service = new HashServiceImpl();
        System.out.println(service.getHashSenha("pedro123"));
        System.out.println();
        System.out.println(service.getHashSenha("fernanda456"));
        System.out.println();
        System.out.println(service.getHashSenha("ricardo789"));
        System.out.println();
        System.out.println(service.getHashSenha("camila101"));
        System.out.println();
        System.out.println(service.getHashSenha("lucas202"));
        System.out.println();
        System.out.println(service.getHashSenha("juliana303"));
        System.out.println();
        System.out.println(service.getHashSenha("marcos404"));
        System.out.println();
        System.out.println(service.getHashSenha("patricia505"));
        System.out.println();
        System.out.println(service.getHashSenha("gustavo606"));
        System.out.println();
        System.out.println(service.getHashSenha("isabela707"));
        System.out.println();
        System.out.println(service.getHashSenha("roberto808"));
        System.out.println();
        System.out.println(service.getHashSenha("felipe010"));
        System.out.println();
        System.out.println(service.getHashSenha("tatiane111"));
        System.out.println();
        System.out.println(service.getHashSenha("rodrigo222"));
        System.out.println();
    
    }
}
