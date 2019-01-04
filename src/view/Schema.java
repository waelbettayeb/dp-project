package view;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
public class Schema extends Pane{
    private int schemaActuelle = 1 ;
    public Schema(){
        super();
        this.setMinWidth(220);
        this.setMinHeight(220);
        this.setMaxWidth(220);
        this.setMaxHeight(220);
    }
    public int getSchemaActuelle() {
        return schemaActuelle;
    }
    public void schemaSuivant(){
        switch (this.schemaActuelle){
            case 1:
                Line line1 = new Line();

                line1.setEndX(200.0f);
                line1.setStartY(200.0f);
                line1.setEndY(200.0f);
                this.getChildren().add(line1);
                break;

            case 2 :
                Line line2 = new Line();
                line2.setStartX(10);
                line2.setStartY(200.0f);
                line2.setEndY(0.0f);
                line2.setEndX(10);
                this.getChildren().add(line2);
                Line line3 = new Line();
                line3.setStartX(10);
                line3.setStartY(0.0f);
                line3.setEndY(0.0f);
                line3.setEndX(100);
                this.getChildren().add(line3);
                break;
            case 3 :
                Line line4 = new Line();
                line4.setStartX(10);
                line4.setStartY(50.0f);
                line4.setEndY(0.0f);
                line4.setEndX(30);
                this.getChildren().add(line4);
                Line line5 = new Line();
                line5.setStartX(100);
                line5.setStartY(0.0f);
                line5.setEndY(40.0f);
                line5.setEndX(100);
                this.getChildren().add(line5);
                break;
            case 4 :
                Ellipse  head = new Ellipse ();
                head.setCenterX(100.0f);
                head.setCenterY(55.0f);
                head.setRadiusX(20.0f);
                head.setRadiusY(15);
                head.setFill(Paint.valueOf("ffffff00"));
                head.setStroke(Color.BLACK);
                this.getChildren().add(head);
                break;
            case 5 :
                Line line6 = new Line();
                line6.setStartX(100);
                line6.setStartY(70.0f);
                line6.setEndY(110.0f);
                line6.setEndX(100);
                this.getChildren().add(line6);
                Line line7 = new Line();
                line7.setStartX(100);
                line7.setStartY(80.0f);
                line7.setEndY(100.0f);
                line7.setEndX(120);
                this.getChildren().add(line7);
                Line line8 = new Line();
                line8.setStartX(100);
                line8.setStartY(80.0f);
                line8.setEndY(105.0f);
                line8.setEndX(90);
                this.getChildren().add(line8);
                break;
            case 6 :
                Line line9 = new Line();
                line9.setStartX(100);
                line9.setStartY(110.0f);
                line9.setEndY(120.0f);
                line9.setEndX(100);
                this.getChildren().add(line9);
                Line line10 = new Line();
                line10.setStartX(100);
                line10.setStartY(120.0f);
                line10.setEndY(160.0f);
                line10.setEndX(120);
                this.getChildren().add(line10);
                Line line11 = new Line();
                line11.setStartX(100);
                line11.setStartY(120.0f);
                line11.setEndY(160.0f);
                line11.setEndX(90);
                this.getChildren().add(line11);
                break;
        }
        this.schemaActuelle++;
    }
}