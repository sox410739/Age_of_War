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

public class hardcontroller extends mazecontroller{
	protected void enemyClub() {
		soldier cl = new soldier(10, 25, 30, 15, 25, 1000, 5, 1000);
		Earr.add(cl);
		cl.setImageView(new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/clubman/stand.png"))),
				140, 100); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		cl.getImageView().setLayoutX(_Ecave.getLayoutX() + 400);
		cl.getImageView().setLayoutY(_generate.getLayoutY());
		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
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
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
				} else if (Earr.indexOf(cl) == 0
						&& ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
								&& _cave.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
										&& _castle.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
										&& _factory.isVisible()))) {
					// touch our house
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	protected void enemySling() {
		soldier cl = new soldier(3, 14, 100, 20, 33, 1500, 225, 1400);
		Earr.add(cl);
		cl.setImageView(
				new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/slingshotman/stand.png"))),
				140, 100); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		cl.getImageView().setLayoutX(_Ecave.getLayoutX() + 400);
		cl.getImageView().setLayoutY(_generate.getLayoutY());

		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
					}
				}
				if (arr.size() > 0 && arr.get(0).getHp() > 0) {
					if ((cl.getImageView().getLayoutX() - cl.getRange()) < (arr.get(0).getImageView().getLayoutX()
							+ arr.get(0).getImageView().getFitWidth())) {
						// encounter enemy
						if (Earr.indexOf(cl) > 0) {
							if (cl.getImageView()
									.getLayoutX() > (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
											+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						} else {
							if (cl.getImageView().getLayoutX() > arr.get(0).getImageView().getLayoutX()
									+ arr.get(0).getImageView().getFitWidth()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						cl.setCount(cl.getCount() + 1);
						if (cl.getCount() == cl.getAtkSpeed() - 50) {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
						}
						if (cl.getCount() == cl.getAtkSpeed()) {
							if (arr.size() > 0) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								bleed(cl.getAtk(), arr.get(0).getImageView());
								arr.get(0).setHp(cl.getAtk());
								if (arr.get(0).getHp() <= 0) {
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
				} else if ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
						&& _cave.isVisible())
						|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
								&& _castle.isVisible())
						|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
								&& _factory.isVisible())) {
					// touch enemy house
					if ((cl.getImageView().getLayoutX() > _cave.getLayoutX() + 400 && _cave.isVisible())
							|| (cl.getImageView().getLayoutX() > _castle.getLayoutX() + 200 && _castle.isVisible())
							|| (cl.getImageView().getLayoutX() > _factory.getLayoutX() + 200 && _factory.isVisible())) {
						if (Earr.indexOf(cl) > 0 && (cl.getImageView()
								.getLayoutX() < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
										+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth()))) {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	protected void enemyDino() {
		soldier cl = new soldier(20, 60, 200, 100, 130, 3000, 5, 1000);
		Earr.add(cl);
		cl.setImageView(
				new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/dinorider/stand.png"))), 200,
				250); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		cl.getImageView().setLayoutX(_Ecave.getLayoutX() + 400 + 75);
		cl.getImageView().setLayoutY(_generate.getLayoutY() - 60);
		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
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
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
					}
				} else if (Earr.indexOf(cl) == 0
						&& ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
								&& _cave.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
										&& _castle.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
										&& _factory.isVisible()))) {
					// touch our house
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	protected void enemySword() {
		soldier cl = new soldier(15, 35, 400, 50, 65, 2000, 5, 900);
		Earr.add(cl);
		cl.setImageView(
				new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/swordman/stand.png"))), 140,
				100); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		cl.getImageView().setLayoutX(_Ecastle.getLayoutX() + 650);
		cl.getImageView().setLayoutY(_generate.getLayoutY());
		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
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
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
				} else if (Earr.indexOf(cl) == 0
						&& ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
								&& _cave.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
										&& _castle.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
										&& _factory.isVisible()))) {
					// touch our house
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	protected void enemyArch() {
		soldier cl = new soldier(5, 25, 500, 70, 95, 2500, 275, 1400);
		Earr.add(cl);
		cl.setImageView(new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/archman/stand.png"))),
				140, 100); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		cl.getImageView().setLayoutX(_Ecastle.getLayoutX() + 650);
		cl.getImageView().setLayoutY(_generate.getLayoutY());

		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
					}
				}
				if (arr.size() > 0 && arr.get(0).getHp() > 0) {
					if ((cl.getImageView().getLayoutX() - cl.getRange()) < (arr.get(0).getImageView().getLayoutX()
							+ arr.get(0).getImageView().getFitWidth())) {
						// encounter enemy
						if (Earr.indexOf(cl) > 0) {
							if (cl.getImageView()
									.getLayoutX() > (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
											+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						} else {
							if (cl.getImageView().getLayoutX() > arr.get(0).getImageView().getLayoutX()
									+ arr.get(0).getImageView().getFitWidth()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						cl.setCount(cl.getCount() + 1);
						if (cl.getCount() == cl.getAtkSpeed() - 50) {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
						}
						if (cl.getCount() == cl.getAtkSpeed()) {
							if (arr.size() > 0) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								bleed(cl.getAtk(), arr.get(0).getImageView());
								arr.get(0).setHp(cl.getAtk());
								if (arr.get(0).getHp() <= 0) {
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
				} else if ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
						&& _cave.isVisible())
						|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
								&& _castle.isVisible())
						|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
								&& _factory.isVisible())) {
					// touch enemy house
					if ((cl.getImageView().getLayoutX() > _cave.getLayoutX() + 400 && _cave.isVisible())
							|| (cl.getImageView().getLayoutX() > _castle.getLayoutX() + 200 && _castle.isVisible())
							|| (cl.getImageView().getLayoutX() > _factory.getLayoutX() + 200 && _factory.isVisible())) {
						if (Earr.indexOf(cl) > 0 && (cl.getImageView()
								.getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
										+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	protected void enemyKnight() {
		soldier cl = new soldier(30, 70, 1000, 200, 260, 5000, 5, 1000);
		Earr.add(cl);
		cl.setImageView(new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/knight/stand.png"))),
				190, 250); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		cl.getImageView().setLayoutX(_Ecastle.getLayoutX() + 650 + 75);
		cl.getImageView().setLayoutY(_generate.getLayoutY() - 60);
		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
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
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
					}
				} else if (Earr.indexOf(cl) == 0
						&& ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
								&& _cave.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
										&& _castle.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
										&& _factory.isVisible()))) {
					// touch our house
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	public void enemyKnife() {
		soldier cl = new soldier(25, 60, 800, 300, 260, 3000, 5, 400);
		Earr.add(cl);
		cl.setImageView(
				new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/knifeman/stand.png"))), 140,
				80); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		cl.getImageView().setLayoutX(_Efactory.getLayoutX() + 600);
		cl.getImageView().setLayoutY(_generate.getLayoutY());
		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
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
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
				} else if (Earr.indexOf(cl) == 0
						&& ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
								&& _cave.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
										&& _castle.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
										&& _factory.isVisible()))) {
					// touch our house
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	public void enemyAk() {
		soldier cl = new soldier(10, 50, 1000, 400, 510, 4000, 250, 1000);
		Earr.add(cl);
		cl.setImageView(new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/akman/stand.png"))),
				140, 100); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		cl.getImageView().setLayoutX(_Efactory.getLayoutX() + 600);
		cl.getImageView().setLayoutY(_generate.getLayoutY());

		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
					}
				}
				if (arr.size() > 0 && arr.get(0).getHp() > 0) {
					if ((cl.getImageView().getLayoutX() - cl.getRange()) < (arr.get(0).getImageView().getLayoutX()
							+ arr.get(0).getImageView().getFitWidth())) {
						// encounter enemy
						if (Earr.indexOf(cl) > 0) {
							if (cl.getImageView()
									.getLayoutX() > (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
											+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						} else {
							if (cl.getImageView().getLayoutX() > arr.get(0).getImageView().getLayoutX()
									+ arr.get(0).getImageView().getFitWidth()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						cl.setCount(cl.getCount() + 1);
						if (cl.getCount() == cl.getAtkSpeed() - 50) {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
						}
						if (cl.getCount() == cl.getAtkSpeed()) {
							if (arr.size() > 0) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								bleed(cl.getAtk(), arr.get(0).getImageView());
								arr.get(0).setHp(cl.getAtk());
								if (arr.get(0).getHp() <= 0) {
									if(arr.get(0).getCost() == 100 || arr.get(0).getCost() == 200 || arr.get(0).getCost() == 2000)
										arr.get(0).specialDead();
									else
										arr.get(0).deadL();
									removeDead(arr.get(0).getImageView());
									arr.remove(arr.get(0));
								}
								cl.setCount(0);
							}
						}
					} else {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
				} else if ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
						&& _cave.isVisible())
						|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
								&& _castle.isVisible())
						|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
								&& _factory.isVisible())) {
					// touch enemy house
					if ((cl.getImageView().getLayoutX() > _cave.getLayoutX() + 400 && _cave.isVisible())
							|| (cl.getImageView().getLayoutX() > _castle.getLayoutX() + 200 && _castle.isVisible())
							|| (cl.getImageView().getLayoutX() > _factory.getLayoutX() + 200 && _factory.isVisible())) {
						if (Earr.indexOf(cl) > 0 && (cl.getImageView()
								.getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
										+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
					}
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}

	public void enemyTank() {
		soldier cl = new soldier(60, 300, 2000, 2000, 3100, 15000, 50, 1600);
		Earr.add(cl);
		cl.setImageView(new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/tank/stand.png"))),
				300, 400); // set view height width
		_field.getChildren().add(cl.getImageView());
		cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		cl.getImageView().setLayoutX(_Efactory.getLayoutX() + 600 + 100);
		cl.getImageView().setLayoutY(_generate.getLayoutY() - 110);
		Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
			if (cl.getHp() > 0) {
				cl.getImageView().setVisible(true);
				if (Earr.indexOf(cl) > 0) {
					// if touch our soldier
					if ((cl.getImageView().getLayoutX()) < (Earr.get(Earr.indexOf(cl) - 1).getImageView().getLayoutX()
							+ Earr.get(Earr.indexOf(cl) - 1).getImageView().getFitWidth())) {
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
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
								if(arr.size() > 1) {
									bleed(cl.getAtk() / 2, arr.get(1).getImageView());
									arr.get(1).setHp(cl.getAtk()/2);
									if (arr.get(1).getHp() <= 0) {
										if(arr.get(1).getCost() == 100 || arr.get(1).getCost() == 200 || arr.get(1).getCost() == 2000)
											arr.get(1).specialDead();
										else
											arr.get(1).deadL();
										removeDead(arr.get(1).getImageView());
										arr.remove(arr.get(1));
									}
								}
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
						cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
					}
				} else if (Earr.indexOf(cl) == 0
						&& ((cl.getImageView().getLayoutX() - cl.getRange() < _cave.getLayoutX() + 400
								&& _cave.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _castle.getLayoutX() + 200
										&& _castle.isVisible())
								|| (cl.getImageView().getLayoutX() - cl.getRange() < _factory.getLayoutX() + 200
										&& _factory.isVisible()))) {
					// touch our house
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
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
					cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
				}
			}
		}));
		clT.setCycleCount(Timeline.INDEFINITE);
		clT.play();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
			if (_Ecave.isVisible()) {
				// time1
				if (exp >= 2500) {
					Ehp = Ehp + 200;
					EfullHp = EfullHp + 200;
					_Ecave.setVisible(false);
					_Ecastle.setVisible(true);
				}
				if (Earr.size() > 5) {
					space = 3000;
				}
				if (Earr.size() <= 5) {
					space = 2000;
				}
				if (exp <= 1000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemyClub();
							break;
						}
					} else {
						switch (ran.nextInt(15)) {
						case 0:
						case 1:
							enemyClub();
							break;
						case 2:
							enemySling();
							break;
						}
					}
				} else if (exp > 1000 && exp < 2500 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemyClub();
							break;
						}
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemySling();
					} else {
						switch (ran.nextInt(12)) {
						case 1:
							enemyClub();
							break;
						case 2:
						case 3:
							enemySling();
							break;
						case 4:
						case 5:
						case 6:
							enemyDino();
							break;
						}
					}
				}
			} else if (_Ecastle.isVisible()) {
				// time2
				if (exp >= 18000) {
					Ehp = Ehp + 400;
					EfullHp = EfullHp + 400;
					_Ecastle.setVisible(false);
					_Efactory.setVisible(true);
				}
				if (Earr.size() > 5) {
					space = 3000;
				}
				if (Earr.size() <= 5) {
					space = 2000;
				}
				if (exp < 7000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemySword();
							break;
						}
					} else {
						switch (ran.nextInt(15)) {
						case 0:
						case 1:
							enemySword();
							break;
						case 2:
							enemyArch();
							break;
						}
					}
				} else if (exp >= 7000 && exp < 15000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemySword();
							break;
						}
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemyArch();
					} else {
						switch (ran.nextInt(12)) {
						case 1:
							enemySword();
							break;
						case 2:
						case 3:
							enemyArch();
							break;
						case 4:
						case 5:
						case 6:
							enemyKnight();
							break;
						}
					}
				} else if (exp <= 18000 && exp >= 15000 && Earr.size() < 10) {
					space = 2000;
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemySword();
							break;
						}
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemyArch();
					} else {
						switch (ran.nextInt(10)) {
						case 0:
							enemySword();
							break;
						case 1:
						case 2:
							enemyArch();
							break;
						case 3:
						case 4:
							enemyKnight();
							break;
						}
					}
				}
			} else if (_Efactory.isVisible()) {
				// time3
				if (Earr.size() > 5) {
					space = 3000;
				}
				if (Earr.size() <= 5) {
					space = 2500;
				}
				if (exp < 30000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemyKnife();
							break;
						}
					} else {
						switch (ran.nextInt(12)) {
						case 0:
						case 1:
							enemyKnife();
							break;
						case 2:
							enemyAk();
							break;
						}
					}
				} else if (exp >= 30000 && exp < 50000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemyKnife();
							break;
						}
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemyAk();
					} else {
						switch (ran.nextInt(10)) {
						case 1:
							enemyKnife();
							break;
						case 2:
						case 3:
							enemyAk();
							break;
						case 4:
						case 5:
						case 6:
							enemyTank();
							break;
						}
					}
				} else if (exp >= 50000 && Earr.size() < 10) {
					space = 2000;
					if (Earr.size() < 1) {
						switch (ran.nextInt(3)) {
						case 1:
						case 0:
							enemyKnife();
							break;
						}
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemyAk();
					} else {
						switch (ran.nextInt(10)) {
						case 0:
							enemyKnife();
							break;
						case 1:
						case 2:
							enemyAk();
							break;
						case 3:
						case 4:
							enemyTank();
							break;
						}
					}
				}
			}
		}));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
	}
}
