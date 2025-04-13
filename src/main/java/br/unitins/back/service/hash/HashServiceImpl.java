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

    private String salt = "#blahxyz22";

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
        System.out.println(service.getHashSenha("123"));
        System.out.println(service.getHashSenha("111"));
        System.out.println(service.getHashSenha("222"));
        System.out.println(service.getHashSenha("333"));
        System.out.println(service.getHashSenha("444"));
        System.out.println(service.getHashSenha("555"));
        System.out.println(service.getHashSenha("666"));
        System.out.println();
        System.out.println("Insira a senha: ");
        String senha = scanner.nextLine();
        System.out.println(service.getHashSenha(senha));
    }
}
