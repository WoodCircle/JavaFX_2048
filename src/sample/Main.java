package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("2048单机");
        primaryStage.getIcons().add(new Image("file:C:\\Users\\WoodCube\\IdeaProjects\\JavaFX\\image\\logo1.png"));

        int[] nums = {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0};
        int[] nums1 = {0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0};
        int[] nums3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0};
        int[] nums4 = {0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0};
        //16个位置的控件
        //
        Text numShow0 = new Text();
        Text numShow1 = new Text();
        Text numShow2 = new Text();
        Text numShow3 = new Text();
        Text numShow4 = new Text();
        Text numShow5 = new Text();
        Text numShow6 = new Text();
        Text numShow7 = new Text();
        Text numShow8 = new Text();
        Text numShow9 = new Text();
        Text numShow10 = new Text();
        Text numShow11 = new Text();
        Text numShow12 = new Text();
        Text numShow13 = new Text();
        Text numShow14 = new Text();
        Text numShow15 = new Text();
        Text[] numShowArray = {numShow0, numShow1, numShow2, numShow3, numShow4, numShow5, numShow6, numShow7, numShow8, numShow9, numShow10, numShow11, numShow12, numShow13, numShow14, numShow15};

        HBox block0 = new HBox();
        HBox block1 = new HBox();
        HBox block2 = new HBox();
        HBox block3 = new HBox();
        HBox block4 = new HBox();
        HBox block5 = new HBox();
        HBox block6 = new HBox();
        HBox block7 = new HBox();
        HBox block8 = new HBox();
        HBox block9 = new HBox();
        HBox block10 = new HBox();
        HBox block11 = new HBox();
        HBox block12 = new HBox();
        HBox block13 = new HBox();
        HBox block14 = new HBox();
        HBox block15 = new HBox();
        HBox[] blockArray = {block0, block1, block2, block3, block4, block5, block6, block7, block8, block9, block10, block11, block12, block13, block14, block15};
        for (int i = 0; i < 16; i++) {
            blockArray[i].setMinSize(100, 100);
            blockArray[i].setPrefSize(100, 100);
            blockArray[i].setMaxSize(100, 100);
            blockArray[i].setAlignment(Pos.CENTER);
            numShowArray[i].setFont(Font.font(45));
        }


        //最外层
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setMinSize(470, 650);
        anchorPane.setPrefSize(470, 650);
        anchorPane.setMaxSize(470, 650);
        anchorPane.setStyle("-fx-background-color:  #FAF8EF");

        //1. HBox  ==============================================================================================
        HBox paneTop = new HBox();
        paneTop.setPadding(new Insets(10, 0, 10, 0));
        paneTop.setMinSize(470, 100);
        paneTop.setPrefSize(470, 100);
        paneTop.setMaxSize(470, 100);
        paneTop.setSpacing(80);
        paneTop.setAlignment(Pos.CENTER);
        //1.1 VBox（最高分）--------------------------------------------
        VBox bestScoreBox = new VBox();
        bestScoreBox.setAlignment(Pos.CENTER);
        bestScoreBox.setPrefSize(100, 200);
        bestScoreBox.setStyle("-fx-background-color: #BBADA0; -fx-background-radius: 5;");
        bestScoreBox.setSpacing(5);
        //Text................................................
        Text bestScoreTitle = new Text("最高分");
        bestScoreTitle.setFont(Font.font(25));
        bestScoreTitle.setFill(Color.rgb(238, 228, 218));
        //Text................................................
        Text bestScore = new Text("2000");
        bestScore.setFont(Font.font(25));
        bestScore.setFill(Color.WHITE);
        //
        bestScoreBox.getChildren().add(bestScoreTitle);
        bestScoreBox.getChildren().add(bestScore);

        //1.2 VBox（当前得分）--------------------------------------------
        VBox scoreBox = new VBox();
        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.setPrefSize(100, 200);
        scoreBox.setStyle("-fx-background-color: #BBADA0; -fx-background-radius: 5;");
        scoreBox.setSpacing(5);
        //Text................................................
        Text scoreTitle = new Text("当前得分");
        scoreTitle.setFont(Font.font(25));
        scoreTitle.setFill(Color.rgb(238, 228, 218));
        //Text................................................
        Text score = new Text("20");
        score.setFont(Font.font(25));
        score.setFill(Color.WHITE);
        //
        scoreBox.getChildren().add(scoreTitle);
        scoreBox.getChildren().add(score);

        //
        paneTop.getChildren().add(bestScoreBox);
        paneTop.getChildren().add(scoreBox);


        //2. FlowPane  ==============================================================================================
        FlowPane paneMid = new FlowPane();
        paneMid.setLayoutX(10);
        paneMid.setLayoutY(100);
        paneMid.setMinSize(450, 450);
        paneMid.setPrefSize(450, 450);
        paneMid.setMaxSize(450, 450);
        paneMid.setHgap(10);
        paneMid.setVgap(10);
        paneMid.setAlignment(Pos.CENTER);
        paneMid.setStyle("-fx-background-color: #BBADA0; -fx-background-radius: 5;");
        paneMid.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

            }
        });
        //16个HBox--------------------------------------------
        reloadBlocks(nums, numShowArray, blockArray);
        for (int i = 0; i < 16; i++) {
            //根据当前位置数字设置样式
            blockArray[i].getChildren().add(numShowArray[i]);
            paneMid.getChildren().add(blockArray[i]);
        }

        //3. HBox  ==============================================================================================
        HBox paneBottom = new HBox();
        paneBottom.setLayoutY(550);
        paneBottom.setMinSize(470, 100);
        paneBottom.setPrefSize(470, 100);
        paneBottom.setMaxSize(470, 100);
        paneBottom.setAlignment(Pos.CENTER);
        //Button--------------------------------------------
        Button newGame = new Button("重新开始");
        newGame.setFont(Font.font(25));
        newGame.setTextFill(Color.rgb(249, 246, 242));
        newGame.setStyle("-fx-background-color: #8F7A66;");
        //点击按钮事件
        newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                reloadBlocks(nums, numShowArray, blockArray);
            }
        });
        //
        paneBottom.getChildren().add(newGame);


        //将三个部分装入anchorPane
        anchorPane.getChildren().add(paneTop);
        anchorPane.getChildren().add(paneMid);
        anchorPane.getChildren().add(paneBottom);

        Scene scene = new Scene(anchorPane, 470, 650);

        //监听键盘
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
                    reloadBlocks(nums1, numShowArray, blockArray);
                }
                if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
                    reloadBlocks(nums2, numShowArray, blockArray);
                }
                if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
                    reloadBlocks(nums3, numShowArray, blockArray);
                }
                if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
                    reloadBlocks(nums4, numShowArray, blockArray);
                }
                if (event.getCode() == KeyCode.R) {
                    reloadBlocks(nums, numShowArray, blockArray);
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void reloadBlocks(int[] nums, Text[] numShowArray, HBox[] blockArray) {
        for (int i = 0; i < 16; i++) {
            //根据当前位置数字设置样式
            switch (nums[i]) {
                case 0:
                    blockArray[i].setStyle("-fx-background-color: #CDC1B4; -fx-background-radius: 5;");
                    numShowArray[i].setText("");
                    //numShowArray[i].setFill(Color.rgb(119, 110, 101));
                    break;
                case 2:
                    blockArray[i].setStyle("-fx-background-color: #EEE4DA; -fx-background-radius: 5;");
                    numShowArray[i].setText("2");
                    numShowArray[i].setFill(Color.rgb(119, 110, 101));
                    break;
                case 4:
                    blockArray[i].setStyle("-fx-background-color: #EDE0C8; -fx-background-radius: 5;");
                    numShowArray[i].setText("4");
                    numShowArray[i].setFill(Color.rgb(119, 110, 101));
                    break;
                case 8:
                    blockArray[i].setStyle("-fx-background-color: #F2B179; -fx-background-radius: 5;");
                    numShowArray[i].setText("8");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 16:
                    blockArray[i].setStyle("-fx-background-color: #F59563; -fx-background-radius: 5;");
                    numShowArray[i].setText("16");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 32:
                    blockArray[i].setStyle("-fx-background-color: #F67C5F; -fx-background-radius: 5;");
                    numShowArray[i].setText("32");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 64:
                    blockArray[i].setStyle("-fx-background-color: #F65E3B; -fx-background-radius: 5;");
                    numShowArray[i].setText("64");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 128:
                    blockArray[i].setStyle("-fx-background-color: #EDCF72; -fx-background-radius: 5;");
                    numShowArray[i].setText("128");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 256:
                    blockArray[i].setStyle("-fx-background-color: #EDCC61; -fx-background-radius: 5;");
                    numShowArray[i].setText("256");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 512:
                    blockArray[i].setStyle("-fx-background-color: #EDC850; -fx-background-radius: 5;");
                    numShowArray[i].setText("512");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 1024:
                    blockArray[i].setStyle("-fx-background-color: #EFC53F; -fx-background-radius: 5;");
                    numShowArray[i].setText("1024");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
                case 2048:
                    blockArray[i].setStyle("-fx-background-color: #E0BA00; -fx-background-radius: 5;");
                    numShowArray[i].setText("2048");
                    numShowArray[i].setFill(Color.rgb(249, 246, 242));
                    break;
            }
        }
    }
}
