package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod Alyokhin
 * Date: 18.04.14
 * Time: 9:48
 */
public class ImageReaderFactory
{
    protected static ImageReader getReader(ImageTypes img) {
        ImageReader imageReader = null;
        if (img == ImageTypes.JPG) imageReader = new JpgReader();
        else if (img == ImageTypes.BMP) imageReader = new BmpReader();
        else if (img == ImageTypes.PNG) imageReader = new PngReader();
        else throw new IllegalArgumentException("неправильный тип картинки");

        System.out.println(imageReader);
        return imageReader;
    }
}
