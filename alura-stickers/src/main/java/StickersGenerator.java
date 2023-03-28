import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;

import java.nio.file.Paths;

public class StickersGenerator {

    public void create(InputStream inputStream, String fileName) throws IOException {

        // leitura da imagem
//        InputStream inputStream = new FileInputStream(new File("assets/filme.jpg"));
//        InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);


        // cria nova imagem em memória com transparência e com tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int stickerBleedArea = 200;
        int newImageHeight = height + stickerBleedArea;

        BufferedImage newImage = new BufferedImage(width, newImageHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // configurar texto, fonte e cor
        String text = "TOPZERA";
        int fontSize = 76;
        Font fontStyle = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        graphics.setColor(Color.RED);
        graphics.setFont(fontStyle);

        /*
         * Para adicionar um segundo texto devemos criar uma nova instância de Font (linha38)
         * com seus respectivos dados, chamar o setFont e o drawString com o novo elemento.
         * */

        // calculando posicionalmento
        var textWidth = graphics.getFontMetrics().stringWidth(text);
        var textHeight = graphics.getFontMetrics().getHeight();
        var horizontalPosition = ((newImage.getWidth()) / 2) - (textWidth / 2);
        var verticalPosition = (newImageHeight - (stickerBleedArea / 2) + (textHeight / 3));

        // escrever uma frase na nova imagem
        graphics.drawString(text, horizontalPosition, verticalPosition);

        // escrever a nova imagem em um arquivo
        String outputFolder = "assets/stickers/";
        Files.createDirectories(Paths.get(outputFolder));
        String folderAndFilename = outputFolder + fileName;
        ImageIO.write(newImage, "png", new File(folderAndFilename));
    }
}
