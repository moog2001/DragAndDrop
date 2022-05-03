package com.example.draganddrop;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

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

    @FXML
    private Label labelStatus;

    Image image00;
    Image image01;
    Image image02;
    Image image03;
    Image image04;


    ArrayList<StackPane> paneArrayList = new ArrayList<>();
    ArrayList<ImageView> imageViewArrayList = new ArrayList<>();
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


    public void init(HelloApplication inputMainApp) {

        mainApp = inputMainApp;
        paneArrayList.add(s00);
        paneArrayList.add(s01);
        paneArrayList.add(s02);
        paneArrayList.add(s03);
        paneArrayList.add(s04);
        paneArrayList.add(s10);
        paneArrayList.add(s11);
        paneArrayList.add(s12);
        paneArrayList.add(s13);
        paneArrayList.add(s14);

        for(StackPane s : paneArrayList){
            ImageView imageView = getImageView(s);
            imageViewArrayList.add(imageView);
        }


        ImageView imageView00 = getImageView(s00);
        image00 = new Image(getClass().getResource("/Images/pic_3.png").toString());
        imageView00.setImage(image00);

        ImageView imageView01 = getImageView(s01);
        image01 = new Image(getClass().getResource("/Images/pic_2.png").toString());
        imageView01.setImage(image01);

        ImageView imageView02 = getImageView(s02);
        image02 = new Image(getClass().getResource("/Images/pic_1.png").toString());
        imageView02.setImage(image02);

        ImageView imageView03 = getImageView(s03);
        image03 = new Image(getClass().getResource("/Images/pic_4.png").toString());
        imageView03.setImage(image03);

        ImageView imageView04 = getImageView(s04);
        image04 = new Image(getClass().getResource("/Images/pic_5.png").toString());
        imageView04.setImage(image04);

        double height = s00.getPrefHeight();
        double width = s00.getPrefWidth();


        for (StackPane s : paneArrayList) {
            s.setStyle("-fx-border-color:black");
            s.setPrefHeight(height);
            s.setPrefWidth(width);
            ImageView imageView = getImageView(s);
            imageView.setFitHeight(height);
            imageView.setFitWidth(width);
//            System.out.println(imageView.getFitHeight());
//            System.out.println(imageView.getFitWidth());

        }

        resetLabel(false);


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


    private boolean isImageEqual(Image firstImage, Image secondImage){
        // Prevent `NullPointerException`
        if(firstImage != null && secondImage == null) return false;
        if(firstImage == null) return secondImage == null;

        // Compare images size


        // Compare images color
        for(int x = 0; x < firstImage.getWidth(); x++){
            for(int y = 0; y < firstImage.getHeight(); y++){
                int firstArgb = firstImage.getPixelReader().getArgb(x, y);
                int secondArgb = secondImage.getPixelReader().getArgb(x, y);

                if(firstArgb != secondArgb) return false;
            }
        }

        return true;
    }


    void handleReset() {

        for(ImageView i : imageViewArrayList){
            if(i.getImage() == null){
                return;
            }
        }

        ImageView imageView10 = getImageView(s10);
        ImageView imageView11 = getImageView(s11);
        ImageView imageView12 = getImageView(s12);
        ImageView imageView13 = getImageView(s13);
        ImageView imageView14 = getImageView(s14);


        if(imageView10.getId() == image02.getUrl() && imageView11.getId() == image01.getUrl() && imageView12.getId() == image00.getUrl() && imageView13.getId() == image03.getUrl() && imageView14.getId() == image04.getUrl()) {
            resetLabel(true);
        }else{
            resetLabel(false);
            
        }

    }

    void resetLabel(boolean check) {
        if (check) {
            labelStatus.setText("zov");
        } else {
            labelStatus.setText("buruu");
        }
    }

    @FXML
    void stackDragDetected(MouseEvent event) {
        ImageView source = (ImageView) event.getSource();
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(source.getImage());
        cb.putUrl(source.getImage().getUrl());
        db.setContent(cb);
        event.consume();
    }


    @FXML
    void stackDragDropped(DragEvent e) {
        ImageView target = (ImageView) e.getTarget();
        Image image = e.getDragboard().getImage();
        target.setImage(image);
        target.setId(e.getDragboard().getUrl());
        handleReset();
        e.consume();
    }


    @FXML
    void stackDragOver(DragEvent e) {
        Dragboard db = e.getDragboard();
        if (db.hasImage()) {
            e.acceptTransferModes(TransferMode.ANY);
        } else {
            e.consume();
        }
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
