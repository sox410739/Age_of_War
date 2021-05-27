package ce1002.Final.s107502533.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ce1002.Final.s107502533.soldier;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class impossiblecontroller extends mazecontroller{
	boolean shu1 = true;
	boolean shu2 = true;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Ehp = 500;
		EfullHp = 500;
		gold = 20000;
		exp = 20000;
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(1), (e) -> {
			count = count + 1;
			_gold.setText("Gold  " + gold);
			_exp.setText("EXP  " + exp);
			_hp.setText("" + Hp);
			_bloodbar.setScaleY((double) Hp / fullHp);
			_bloodbar.setLayoutY((double) 215 + (339 - 339 * Hp / fullHp) / 2);
			_Ehp.setText("" + Ehp);
			_Ebloodbar.setScaleY((double) Ehp / EfullHp);
			_Ebloodbar.setLayoutY((double) 215 + (339 - 339 * Ehp / EfullHp) / 2);
			if(count % 6000 == 0) {
				enemyClub();
			}
			if(Ehp < 300 && shu1) {
				plane();
				shu1 = false;
			}
			if(Ehp < 100 && shu2) {
				superClubman();
				shu2 = false;
			}
		}));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
	}
	
	public void plane() {
		ImageView plane = new ImageView(new Image(getClass().getResourceAsStream("resource/plane.png")));
		plane.setLayoutX(1600);
		plane.setLayoutY(180);
		plane.setFitWidth(350);
		plane.setFitHeight(250);
		plane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		_field.getChildren().add(plane);
		Timeline fly = new Timeline(new KeyFrame(Duration.millis(10), (e1) -> {
			plane.setLayoutX(plane.getLayoutX() - 20);
			if (plane.getLayoutX() < -500) {
				_field.getChildren().remove(plane);
			}
		}));
		fly.setCycleCount(500);
		fly.play();
		Timeline bl = new Timeline(new KeyFrame(Duration.millis(20), (e1) -> {
			Iboom(plane);
		}));
		bl.setCycleCount(50);
		bl.play();
	}
	
	protected void Iboom(ImageView plane) {
		boolean hit = true;
		ImageView bullet = new ImageView(new Image(getClass().getResourceAsStream("resource/bullet.png")));
		bullet.setLayoutX(plane.getLayoutX());
		bullet.setLayoutY(180);
		bullet.setFitWidth(30);
		bullet.setFitHeight(200);
		_field.getChildren().add(bullet);
		ImageView explosure = new ImageView(new Image(getClass().getResourceAsStream("resource/bang.png")));
		explosure.setLayoutX(bullet.getLayoutX() - 15);
		explosure.setLayoutY(685);
		explosure.setFitHeight(100);
		explosure.setFitWidth(130);
		_field.getChildren().add(explosure);
		explosure.setVisible(false);
		
		Timeline bang = new Timeline(new KeyFrame(Duration.millis(50), (e)-> {
			explosure.setOpacity(explosure.getOpacity() - 0.05);
			explosure.setFitHeight(explosure.getFitHeight() + 10);
			explosure.setLayoutY(explosure.getLayoutY() - 10);
			if(explosure.getOpacity() == 0) {
				_field.getChildren().remove(explosure);
			}
		}));
		bang.setCycleCount(20);
		
		Timeline Rotate = new Timeline(new KeyFrame(Duration.millis(1), (e) -> {
			bullet.setRotate(bullet.getRotate() + 1);
		}));
		Rotate.setCycleCount(5000);
		Rotate.play();
		Timeline down = new Timeline(new KeyFrame(Duration.millis(20), (e) -> {
			bullet.setLayoutY(bullet.getLayoutY() + 5);
			if (bullet.getLayoutY() >= 760) {
				_field.getChildren().remove(bullet);
				changBoolean(hit);
				explosure.setVisible(true);
				bang.play();
			}
			for (int i = 0; i < arr.size(); i++) {
				if (bullet.getLayoutX() > arr.get(i).getImageView().getLayoutX()
						&& bullet.getLayoutX() < arr.get(i).getImageView().getLayoutX()
								+ arr.get(i).getImageView().getFitWidth()
						&& bullet.getLayoutY() >= arr.get(i).getImageView().getLayoutY() - 50
						&& bullet.getLayoutY() <= arr.get(i).getImageView().getLayoutY() && hit) {
					_field.getChildren().remove(bullet);
					bleed(40, arr.get(i).getImageView());
					arr.get(i).setHp(40);
					changBoolean(hit);
					explosure.setVisible(true);
					bang.play();
					if (arr.get(i).getHp() <= 0) {
						if(arr.get(i).getCost() == 100 || arr.get(i).getCost() == 200 || arr.get(i).getCost() == 2000)
							arr.get(i).specialDead();
						else
							arr.get(i).deadL();
						removeDead(arr.get(i).getImageView());
						arr.remove(arr.get(i));
						i--;
					}
				}
			}
		}));
		down.setCycleCount(120);
		down.play();
	}
	
	public void superClubman() {
		soldier cl = new soldier(1000, 80, 10, 15, 25, 1000, 5, 100);
		Earr.add(cl);
		cl.setImageView(new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/clubman/stand.png"))),
				800, 660); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		cl.getImageView().setLayoutX(_Ecave.getLayoutX() + 400);
		cl.getImageView().setLayoutY(_generate.getLayoutY() - 600);
		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 1);
					}
				}
				if (arr.size() > 0 && arr.get(0).getHp() > 0) {
					if ((cl.getImageView().getLayoutX() - cl.getRange()) < (arr.get(0).getImageView().getLayoutX()
							+ arr.get(0).getImageView().getFitWidth())) {
						cl.setCount(cl.getCount() + 1);
						if (cl.getCount() == cl.getAtkSpeed() * 2 - 50) {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
						}
						if (cl.getCount() == cl.getAtkSpeed() * 2) {
							if (arr.size() > 0) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								bleed(cl.getAtk(), arr.get(0).getImageView());
								arr.get(0).setHp(cl.getAtk());
								if (arr.get(0).getHp() <= 0) {
									arr.get(0).beTankKilledL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 1);
					}
				} else if (Earr.indexOf(cl) == 0
						&& ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
								&& _cave.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
										&& _castle.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
										&& _factory.isVisible()))) {
					// touch our house
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 1);
					cl.setCount(cl.getCount() + 1);
					if (cl.getCount() == cl.getAtkSpeed() - 50) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
					}
					if (cl.getCount() == cl.getAtkSpeed()) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
						Hp = Hp - cl.getAtk();
						if (Hp <= 0) {
							try {
								lose();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						cl.setCount(0);
					}
				} else {
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 1);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}
	
}
