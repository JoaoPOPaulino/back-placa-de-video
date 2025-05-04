package br.unitins.back.service.usuario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jboss.logging.Logger;

import br.unitins.back.resource.UsuarioResource;
import br.unitins.back.service.FileService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioFileService implements FileService {

    private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());

    private final String PATH_USER = System.getProperty("user.home")
            + File.separator + "quarkus"
            + File.separator + "images"
            + File.separator + "usuarios" + File.separator;

    private static final List<String> SUPPORTED_MIME_TYPES = Arrays.asList("image/jpeg", "image/jpg", "image/png",
            "image/gif");

    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;

    @Override
    public String salvar(String nomeArquivo, byte[] arquivo) throws IOException {
        LOGGER.info("Iniciando processo de salvamento do arquivo.");
        verificarTamanhoImagem(arquivo);
        verificarTipoImagem(nomeArquivo);

        Path diretorio = Paths.get(PATH_USER);
        Files.createDirectories(diretorio);

        Path filePath;
        String novoNomeArquivo;

        do {
            String mimeType = Files.probeContentType(Paths.get(nomeArquivo));
            String extensao = mimeType.substring(mimeType.lastIndexOf("/") + 1);
            novoNomeArquivo = UUID.randomUUID() + "." + extensao;
            filePath = diretorio.resolve(novoNomeArquivo);
        } while (filePath.toFile().exists());

        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
            fos.write(arquivo);
        }

        LOGGER.info("Arquivo salvo com sucesso: " + novoNomeArquivo);
        return filePath.toFile().getName();
    }

    @Override
    public File obter(String nomeArquivo) {
        File file = new File(PATH_USER + nomeArquivo);
        return file;
    }

    public void delete(String nomeArquivo) throws IOException {
        LOGGER.info("Iniciando exclusão do arquivo: " + nomeArquivo);
        Path filePath = Paths.get(PATH_USER, nomeArquivo);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
            LOGGER.info("Arquivo excluído com sucesso: " + nomeArquivo);
        } else {
            LOGGER.warn("Arquivo não encontrado para exclusão: " + nomeArquivo);
        }
    }

    private void verificarTamanhoImagem(byte[] arquivo) throws IOException {
        if (arquivo.length > MAX_FILE_SIZE) {
            throw new IOException("Arquivo maior que 10MB");
        }
    }

    private void verificarTipoImagem(String nomeArquivo) throws IOException {
        String mimeType = Files.probeContentType(Paths.get(nomeArquivo));
        if (mimeType == null || !SUPPORTED_MIME_TYPES.contains(mimeType)) {
            throw new IOException("Tipo de imagem não suportada ou não reconhecida.");
        }
    }
}
