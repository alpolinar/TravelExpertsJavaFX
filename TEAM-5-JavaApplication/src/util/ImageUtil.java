package util;

import java.io.File;
import javafx.scene.image.Image;

/**This class manages the account images for the application.
 *
 * @author Al Polinar
 */
public class ImageUtil {
    //gets the default image

    /**This method returns a scene Image.
     * <p>Example:</p>
     * <p><code>imageView.setImage(getImage("default.jpg"));</code></p>
     * @param imageName
     * @return Image
     */
    public Image getImage(String imageName){
        File dir = new File(System.getProperty("user.dir")+"\\src\\img\\"+imageName);
        Image image = new Image(dir.toURI().toString());
        return image;
    }
}
