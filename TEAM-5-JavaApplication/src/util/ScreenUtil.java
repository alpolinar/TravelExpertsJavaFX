package util;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ScreenUtil {
    private double xOffset=0;
    private double yOffset=0;
    private double dOffsetX=0;
    private double dOffsetY=0;
    
    /**This method sets a drag listener to a component.
     *
     * @param root
     * @param stage
     */
    public void setDragListener(final Node root, Stage stage){
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = stage.getX();
            yOffset = stage.getY();
            dOffsetX = event.getScreenX();
            dOffsetY = event.getScreenY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(xOffset+getDiff(dOffsetX,event.getScreenX()));
            stage.setY(yOffset+getDiff(dOffsetY,event.getScreenY()));
        }); 
    }
    
    private double getDiff(double x, double y){
        double diff = y-x;
        return diff;
    }
}
