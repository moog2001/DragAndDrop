package com.example.draganddrop;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private StackPane s00;

    @FXML
    private StackPane s01;

    @FXML
    private StackPane s02;

    @FXML
    private StackPane s03;

    @FXML
    private StackPane s04;

    @FXML
    private StackPane s10;

    @FXML
    private StackPane s11;

    @FXML
    private StackPane s12;

    @FXML
    private StackPane s13;

    @FXML
    private StackPane s14;

    ArrayList<StackPane> paneArrayList = new ArrayList<>();
    ArrayList<Image> imageArrayList = new ArrayList<>();
    HelloApplication mainApp;

    @FXML
    public void initialize() {
//        paneArrayList.add(s00);
//        paneArrayList.add(s01);
//        paneArrayList.add(s02);
//        paneArrayList.add(s03);
//        paneArrayList.add(s04);
//        paneArrayList.add(s11);
//        paneArrayList.add(s12);
//        paneArrayList.add(s13);
//        paneArrayList.add(s14);
//
//        ImageView imageView00 = getImageView(s00);
//        Image image00 = new Image(getClass().getResource("Images/pic_3.png").toString());
//        imageView00.setImage(image00);


//        for(StackPane stackPane :paneArrayList){
//            ImageView imageView = getImageView(stackPane);
//
//        }

    }



    public void init(HelloApplication inputMainApp){

        mainApp = inputMainApp;
        paneArrayList.add(s00);
        paneArrayList.add(s01);
        paneArrayList.add(s02);
        paneArrayList.add(s03);
        paneArrayList.add(s04);
        paneArrayList.add(s11);
        paneArrayList.add(s12);
        paneArrayList.add(s13);
        paneArrayList.add(s14);

        ImageView imageView00 = getImageView(s00);
        Image image00 = new Image(getClass().getResource("/Images/pic_3.png").toString());
        imageView00.setImage(image00);

        ImageView imageView01 = getImageView(s01);
        Image image01 = new Image(getClass().getResource("/Images/pic_2.png").toString());
        imageView01.setImage(image01);

        ImageView imageView02 = getImageView(s02);
        Image image02 = new Image(getClass().getResource("/Images/pic_1.png").toString());
        imageView02.setImage(image02);

        ImageView imageView03 = getImageView(s03);
        Image image03 = new Image(getClass().getResource("/Images/pic_4.png").toString());
        imageView03.setImage(image03);

        ImageView imageView04 = getImageView(s04);
        Image image04 = new Image(getClass().getResource("/Images/pic_5.png").toString());
        imageView04.setImage(image04);

        double height = s00.getHeight();


        s10.setMinHeight(height);
        s11.setMinHeight(height);
        s12.setMinHeight(height);
        s13.setMinHeight(height);


//
//        ImageView imageView10 = getImageView(s00);
//        Image image10 = new Image(getClass().getResource("/Images/pic_3.png").toString());
//        imageView00.setImage(image00);
//
//        ImageView imageView11 = getImageView(s00);
//        Image image11 = new Image(getClass().getResource("/Images/pic_3.png").toString());
//        imageView00.setImage(image00);
//
//        ImageView imageView12 = getImageView(s00);
//        Image image12 = new Image(getClass().getResource("/Images/pic_3.png").toString());
//        imageView00.setImage(image00);
//
//        ImageView imageView13 = getImageView(s00);
//        Image image13 = new Image(getClass().getResource("/Images/pic_3.png").toString());
//        imageView00.setImage(image00);
//
//        ImageView imageView14 = getImageView(s00);
//        Image image14 = new Image(getClass().getResource("/Images/pic_3.png").toString());
//        imageView00.setImage(image00);


//        for(StackPane stackPane :paneArrayList){
//            ImageView imageView = getImageView(stackPane);
//
//        }
    }


    void handleReset() {

    }

    void resetLabel() {

    }


    @FXML
    void stackDragDropped(DragEvent event) {

    }

    @FXML
    void stackDragExited(MouseDragEvent event) {

    }

    @FXML
    void stackDragOver(DragEvent event) {

    }

    void addImage(Image i, StackPane pane) {


        ImageView imageView = new ImageView();
        imageView.setImage(i);
        pane.getChildren().add(imageView);
    }

    private ImageView getImageView(StackPane parent) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof ImageView) {
                return (ImageView) node;
            }
        }
        return new ImageView("Images/empty.png");
    }


    private void mouseDragDropped(final DragEvent e) {
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            final File file = db.getFiles().get(0);

            StackPane contentPane = ((StackPane) e.getSource());

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println(file.getAbsolutePath());
                    try {
                        if (!contentPane.getChildren().isEmpty()) {
                            contentPane.getChildren().remove(0);
                        }
                        Image img = new Image(new FileInputStream(file.getAbsolutePath()));

                        addImage(img, contentPane);
                    } catch (FileNotFoundException ex) {
                        System.out.println(e.toString());
                    }
                }
            });
        }
        e.setDropCompleted(success);
        e.consume();
    }

    private void mouseDragOver(final DragEvent e) {
        final Dragboard db = e.getDragboard();

        final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg");

        StackPane contentPane = ((StackPane) e.getSource());

        if (db.hasFiles()) {
            if (isAccepted) {
                contentPane.setStyle("-fx-border-color: red;"
                        + "-fx-border-width: 5;"
                        + "-fx-background-color: #C6C6C6;"
                        + "-fx-border-style: solid;");
                e.acceptTransferModes(TransferMode.MOVE);
            }
        } else {
            e.consume();
        }
    }

}
