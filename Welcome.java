/*
* Random thing I made real quick to welcome new guys
*/

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Welcome extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
        Image image = new Image(getClass().getResourceAsStream("assets/new_guys.png"));
		ImageView view = new ImageView(image);
        Rectangle2D  screenBounds = Screen.getPrimary().getVisualBounds();
        double startPos = screenBounds.getMaxX();
        double endPos = startPos / 2 - (image.getWidth() / 2);
        DoubleProperty x = new SimpleDoubleProperty(startPos);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
            new Timeline(new KeyFrame(Duration.seconds(5), ev -> stage.close())).play();
        }, new KeyValue(x, endPos)));
        x.addListener((obs, oldValue, newValue) -> stage.setX(newValue.doubleValue()));
        timeline.play();


		Group root = new Group();
		root.getChildren().add(view);
		stage.setScene(new Scene(root, Color.TRANSPARENT));
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
	}
}
