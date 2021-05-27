package ce1002.Final.s107502533.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import ce1002.Final.s107502533.Final;
import ce1002.Final.s107502533.soldier;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class mazecontroller implements Initializable {
	@FXML
	ImageView _generate;
	@FXML
	ImageView _soldier, _ability1, _ability2, _ability3, _levelup;
	@FXML
	ImageView _club, _slingshot, _dino, _back;
	@FXML
	ImageView _sword, _arch, _knight;
	@FXML
	ImageView _knife, _ak, _tank;
	@FXML
	Pane _field, _wait;
	@FXML
	Button _enemy;
	@FXML
	ImageView _cave, _castle, _factory, _Ecave, _Ecastle, _Efactory;
	@FXML
	Label _gold, _exp, _hp, _Ehp, _infoname, _infocost, _cool;
	@FXML
	ImageView _bloodbar, _Ebloodbar, _load1, _load2, _load3;

	ArrayList<soldier> arr = new ArrayList<soldier>();
	ArrayList<soldier> Earr = new ArrayList<soldier>();
	int time = 1;
	int exp = 0;
	int gold = 175;
	int fullHp = 200;
	int EfullHp = 200;
	int Hp = 200;
	int Ehp = 200;
	int count = 0;
	Random ran = new Random();
	int space = 3000;
	int ability1 = 21;
	int ability2 = 41;
	int ability3 = 31;
	int temp = 0;

	public void onEnemyPressed(ActionEvent e) {
		if(_Ecave.isVisible()) {
			switch(ran.nextInt(3)) {
			case 0:
				enemyClub();
				break;
			case 1:
				enemySling();
				break;
			case 2:
				enemyDino();
				break;
			}
		}
		else if(_Ecastle.isVisible()) {
			switch(ran.nextInt(3)) {
			case 0:
				enemySword();
				break;
			case 1:
				enemyArch();
				break;
			case 2:
				enemyKnight();
				break;
			}
		}
		else if(_Efactory.isVisible()) {
			switch(ran.nextInt(3)) {
			case 0:
				enemyKnife();
				break;
			case 1:
				enemyAk();
				break;
			case 2:
				enemyTank();
				break;
			}
		}
	}
	
	public void onMoneyPressed(ActionEvent e) {
		gold = gold + 5000;
	}
	
	public void onExpPressed(ActionEvent e) {
		exp = exp + 3000;
	}
	
	public void on0cdPressed(ActionEvent e) {
		_cool.setVisible(false);
		_wait.setVisible(false);
	}
	
	public void onLevelupPressed(MouseEvent e) {
		if(time != 3) {
			if (exp >= 20000 && time == 2) {
				time = 3;
				Hp = Hp + 400;
				fullHp = fullHp + 400;
				_ability1.setVisible(false);
				_ability2.setVisible(false);
				_ability3.setVisible(true);
				_cave.setVisible(false);
				_castle.setVisible(false);
				_factory.setVisible(true);
			} else if (exp >= 3000 && time == 1) {
				time = 2;
				Hp = Hp + 200;
				fullHp = fullHp + 200;
				_ability1.setVisible(false);
				_ability2.setVisible(true);
				_ability3.setVisible(false);
				_cave.setVisible(false);
				_castle.setVisible(true);
				_factory.setVisible(false);
			}
		}
		else {
		}
	}

	public void onBackPressed(MouseEvent e) {
		if (ability1 > 0 && ability1 < 21) {
			_wait.setVisible(true);
			_cool.setVisible(true);
		}
		else if (ability2 > 0 && ability2 < 41) {
			_wait.setVisible(true);
			_cool.setVisible(true);
		}
		else if (ability3 > 0 && ability3 < 31) {
			_wait.setVisible(true);
			_cool.setVisible(true);
		}
		_soldier.setVisible(true);
		_levelup.setVisible(true);
		_back.setVisible(false);
		if (time == 1) {
			_ability1.setVisible(true);
			_club.setVisible(false);
			_slingshot.setVisible(false);
			_dino.setVisible(false);
		} else if (time == 2) {
			_ability2.setVisible(true);
			_sword.setVisible(false);
			_arch.setVisible(false);
			_knight.setVisible(false);
		} else if (time == 3) {
			_ability3.setVisible(true);
			_knife.setVisible(false);
			_ak.setVisible(false);
			_tank.setVisible(false);
		}
	}

	public void onSoldierPressed(MouseEvent e) {
		if (_wait.isVisible()) {
			_wait.setVisible(false);
			_cool.setVisible(false);
		}
		_soldier.setVisible(false);
		_levelup.setVisible(false);
		_back.setVisible(true);
		if (time == 1) {
			_ability1.setVisible(false);
			if(_load1.getScaleX() == 0)
				_club.setVisible(true);
			if(_load2.getScaleX() == 0)
				_slingshot.setVisible(true);
			if(_load3.getScaleX() == 0)
				_dino.setVisible(true);
		} else if (time == 2) {
			_ability2.setVisible(false);
			if(_load1.getScaleX() == 0)	
				_sword.setVisible(true);
			if(_load2.getScaleX() == 0)
				_arch.setVisible(true);
			if(_load3.getScaleX() == 0)
				_knight.setVisible(true);
		} else if (time == 3) {
			_ability3.setVisible(false);
			if(_load1.getScaleX() == 0)
				_knife.setVisible(true);
			if(_load2.getScaleX() == 0)
				_ak.setVisible(true);
			if(_load3.getScaleX() == 0)
				_tank.setVisible(true);
		}
	}

	public void onAbility1Pressed(MouseEvent e) {
		ability1--;
		_wait.setVisible(true);
		_cool.setVisible(true);
		_cool.setText("" + ability1);
		Timeline wait = new Timeline(new KeyFrame(Duration.millis(1000), (e1) -> {
			ability1 = ability1 - 1;
			_cool.setText("" + ability1);
			if (ability1 == 0) {
				_wait.setVisible(false);
				_cool.setVisible(false);
				ability1 = 21;
			}
		}));
		wait.setCycleCount(20);
		wait.play();
		ImageView rock = new ImageView(new Image(getClass().getResourceAsStream("resource/rock.png")));
		_field.getChildren().add(rock);
		rock.setLayoutX(-650);
		rock.setLayoutY(-410);
		rock.setFitWidth(650);
		rock.setFitHeight(450);
		Timeline fireCtrl = new Timeline(new KeyFrame(Duration.millis(3000), (e2) -> {
			_field.getChildren().remove(rock);
			for (int i = 0; i < Earr.size(); i++) {
				if (Earr.get(i).getImageView().getLayoutX() >= 600) {
					Earr.get(i).setHp(50);
					bleed(50, Earr.get(i).getImageView());
					if (Earr.get(i).getHp() <= 0) {
						gold = gold + Earr.get(i).getReward();
						exp = exp + Earr.get(i).getExp();
						getGold(Earr.get(i));
						if(Earr.get(i).getCost() == 100 || Earr.get(i).getCost() == 200 || Earr.get(i).getCost() == 2000)
							Earr.get(i).specialDead();
						else
							Earr.get(i).deadR();

						removeDead(Earr.get(i).getImageView());
						Earr.remove(Earr.get(i));
						i--;
					}
				}
			}
		}));
		fireCtrl.setCycleCount(1);
		fireCtrl.play();
		
		Timeline fire = new Timeline(new KeyFrame(Duration.millis(20), (e2) -> {
			rock.setLayoutX(rock.getLayoutX() + 7.2);
			rock.setLayoutY(rock.getLayoutY() + 5);
		}));
		fire.setCycleCount(150);
		fire.play();

		Timeline earthquake = new Timeline(new KeyFrame(Duration.millis(100), (e2) -> {
			_field.setLayoutX(_field.getLayoutX() - 20);
			Timeline earthquakeR = new Timeline(new KeyFrame(Duration.millis(100), (e3) -> {
				_field.setLayoutX(_field.getLayoutX() + 20);
			}));
			earthquakeR.setCycleCount(1);
			earthquakeR.play();
			Timeline earthquakeU = new Timeline(new KeyFrame(Duration.millis(100), (e3) -> {
				_field.setLayoutY(_field.getLayoutY() - 20);
				Timeline earthquakeD = new Timeline(new KeyFrame(Duration.millis(100), (e4) -> {
					_field.setLayoutY(_field.getLayoutY() + 20);
				}));
				earthquakeD.setCycleCount(1);
				earthquakeD.play();
			}));
			earthquakeU.setCycleCount(1);
			earthquakeU.play();
		}));
		earthquake.setCycleCount(30);
		earthquake.play();
	}

	public void onAbility2Pressed(MouseEvent e) {
		ability2--;
		_wait.setVisible(true);
		_cool.setVisible(true);
		_cool.setText("" + ability2);
		Timeline wait = new Timeline(new KeyFrame(Duration.millis(1000), (e1) -> {
			ability2 = ability2 - 1;
			_cool.setText("" + ability2);
			if (ability2 == 0) {
				_wait.setVisible(false);
				_cool.setVisible(false);
				ability2 = 41;
			}
		}));
		wait.setCycleCount(40);
		wait.play();
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).setAtkSpeed(arr.get(i).getAtkSpeed() / 2);
			arr.get(i).setAtk(arr.get(i).getAtk() * 2);
			arr.get(i).larger();
		}
	}

	public void onAbility3Pressed(MouseEvent e) {		
		ability3--;
		_wait.setVisible(true);
		_cool.setVisible(true);
		_cool.setText("" + ability3);
		Timeline wait = new Timeline(new KeyFrame(Duration.millis(1000), (e1) -> {
			ability3 = ability3 - 1;
			_cool.setText("" + ability3);
			if (ability3 == 0) {
				_wait.setVisible(false);
				_cool.setVisible(false);
				ability3 = 31;
			}
		}));
		wait.setCycleCount(30);
		wait.play();
		ImageView plane = new ImageView(new Image(getClass().getResourceAsStream("resource/plane.png")));
		plane.setLayoutX(-380);
		plane.setLayoutY(180);
		plane.setFitWidth(350);
		plane.setFitHeight(250);
		_field.getChildren().add(plane);
		Timeline fly = new Timeline(new KeyFrame(Duration.millis(10), (e1) -> {
			plane.setLayoutX(plane.getLayoutX() + 3);
			if (plane.getLayoutX() > 1600) {
				_field.getChildren().remove(plane);
			}
		}));
		fly.setCycleCount(1000);
		fly.play();
		Timeline bl = new Timeline(new KeyFrame(Duration.millis(400), (e1) -> {
			boom(plane);
		}));
		bl.setCycleCount(20);
		bl.play();
	}

	public void onClubPressed(MouseEvent e) {
		if (gold >= 15 && arr.size() < 10) {
			soldier cl = new soldier(5, 18, 20, 15, 20, 1000, 5, 1000);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/clubman/stand.png"))),
					140, 100); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
			cl.getImageView().setLayoutX(_cave.getLayoutX() + 400);
			cl.getImageView().setLayoutY(_generate.getLayoutY());
			_club.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load1.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load1.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 1) {
					_club.setVisible(true);
				}
				_load1.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if ((cl.getImageView().getLayoutX() + cl.getRange()
									+ cl.getImageView().getFitWidth()) > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() * 2 - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								}
								if (cl.getCount() == cl.getAtkSpeed() * 2) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200 || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
						} else if (arr.indexOf(cl) == 0 && ((cl.getImageView().getLayoutX()
								+ cl.getImageView().getFitWidth() + cl.getRange() > _Ecave.getLayoutX() + 400
								&& _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onSlingPressed(MouseEvent e) {
		if (gold >= 20 && arr.size() < 10) {
			soldier cl = new soldier(2, 12, 40, 20, 33, 1500, 375, 1400);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(
							new Image(getClass().getResourceAsStream("resource/soldiers/slingshotman/stand.png"))),
					140, 100); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
			cl.getImageView().setLayoutX(_cave.getLayoutX() + 400);
			cl.getImageView().setLayoutY(_generate.getLayoutY());
			_slingshot.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load2.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load2.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 1) {
					_slingshot.setVisible(true);
				}
				_load2.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if (cl.getImageView().getLayoutX()
									+ cl.getRange() > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								if (arr.indexOf(cl) > 0) {
									if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) < (arr
											.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
									}
								} else {
									if (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth() < Earr.get(0)
											.getImageView().getLayoutX()) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
									}
								}
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								}
								if (cl.getCount() == cl.getAtkSpeed()) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200 || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
						} else if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
								+ cl.getRange() > _Ecave.getLayoutX() + 400 && _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible())) {
							// touch enemy house
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth() < _Ecave.getLayoutX()
									+ 400 && _Ecave.isVisible())
									|| (cl.getImageView().getLayoutX()
											+ cl.getImageView().getFitWidth() < _Ecastle.getLayoutX() + 650
											&& _Ecastle.isVisible())
									|| (cl.getImageView().getLayoutX()
											+ cl.getImageView().getFitWidth() < _Efactory.getLayoutX() + 600
											&& _Efactory.isVisible())) {
								if (arr.indexOf(cl) > 0
										&& (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
												.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
								}
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onDinoPressed(MouseEvent e) {
		if (gold >= 100 && arr.size() < 10) {
			soldier cl = new soldier(10, 30, 80, 100, 130, 3000, 5, 1000);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/dinorider/stand.png"))),
					200, 250); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
			cl.getImageView().setLayoutX(_cave.getLayoutX() + 400 - 75);
			cl.getImageView().setLayoutY(_generate.getLayoutY() - 60);
			_dino.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load3.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load3.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 1) {
					_dino.setVisible(true);
				}
				_load3.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if ((cl.getImageView().getLayoutX() + cl.getRange()
									+ cl.getImageView().getFitWidth()) > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() * 2 - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 10);
								}
								if (cl.getCount() == cl.getAtkSpeed() * 2) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 10);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200 || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
							}
						} else if (arr.indexOf(cl) == 0 && ((cl.getImageView().getLayoutX()
								+ cl.getImageView().getFitWidth() + cl.getRange() > _Ecave.getLayoutX() + 400
								&& _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 10);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 10);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onSwordPressed(MouseEvent e) {
		if (gold >= 50 && arr.size() < 10) {
			soldier cl = new soldier(10, 30, 100, 50, 65, 2000, 5, 900);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/swordman/stand.png"))),
					140, 100); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
			cl.getImageView().setLayoutX(_castle.getLayoutX() + 200);
			cl.getImageView().setLayoutY(_generate.getLayoutY());
			_sword.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load1.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load1.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 2) {
					_sword.setVisible(true);
				}
				_load1.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if ((cl.getImageView().getLayoutX() + cl.getRange()
									+ cl.getImageView().getFitWidth()) > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() * 2 - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								}
								if (cl.getCount() == cl.getAtkSpeed() * 2) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200  || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
						} else if (arr.indexOf(cl) == 0 && ((cl.getImageView().getLayoutX()
								+ cl.getImageView().getFitWidth() + cl.getRange() > _Ecave.getLayoutX() + 400
								&& _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onArchPressed(MouseEvent e) {
		if (gold >= 70 && arr.size() < 10) {
			soldier cl = new soldier(4, 22, 140, 70, 95, 2500, 375, 1400);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/archman/stand.png"))),
					140, 100); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
			cl.getImageView().setLayoutX(_castle.getLayoutX() + 200);
			cl.getImageView().setLayoutY(_generate.getLayoutY());
			_arch.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load2.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load2.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 2) {
					_arch.setVisible(true);
				}
				_load2.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if (cl.getImageView().getLayoutX()
									+ cl.getRange() > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								if (arr.indexOf(cl) > 0) {
									if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) < (arr
											.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
									}
								} else {
									if (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth() < Earr.get(0)
											.getImageView().getLayoutX()) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
									}
								}
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								}
								if (cl.getCount() == cl.getAtkSpeed()) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200  || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
						} else if (((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
								+ cl.getRange() > _Ecave.getLayoutX() + 400 && _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth() < _Ecave.getLayoutX()
									+ 400 && _Ecave.isVisible())
									|| (cl.getImageView().getLayoutX()
											+ cl.getImageView().getFitWidth() < _Ecastle.getLayoutX() + 650
											&& _Ecastle.isVisible())
									|| (cl.getImageView().getLayoutX()
											+ cl.getImageView().getFitWidth() < _Efactory.getLayoutX() + 600
											&& _Efactory.isVisible())) {
								if (arr.indexOf(cl) > 0
										&& (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
												.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
								}
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onKnightPressed(MouseEvent e) {
		if (gold >= 200 && arr.size() < 10) {
			soldier cl = new soldier(20, 50, 400, 200, 260, 5000, 5, 1000);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/knight/stand.png"))), 190,
					250); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
			cl.getImageView().setLayoutX(_castle.getLayoutX() + 200 - 75);
			cl.getImageView().setLayoutY(_generate.getLayoutY() - 60);
			_knight.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load3.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load3.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 2) {
					_knight.setVisible(true);
				}
				_load3.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if ((cl.getImageView().getLayoutX() + cl.getRange()
									+ cl.getImageView().getFitWidth()) > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() * 2 - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 10);
								}
								if (cl.getCount() == cl.getAtkSpeed() * 2) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 10);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200 || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
							}
						} else if (arr.indexOf(cl) == 0 && ((cl.getImageView().getLayoutX()
								+ cl.getImageView().getFitWidth() + cl.getRange() > _Ecave.getLayoutX() + 400
								&& _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 10);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 10);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onKnifePressed(MouseEvent e) {
		if (gold >= 200 && arr.size() < 10) {
			soldier cl = new soldier(18, 50, 600, 300, 260, 3000, 5, 400);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/knifeman/stand.png"))),
					140, 80); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
			cl.getImageView().setLayoutX(_factory.getLayoutX() + 200);
			cl.getImageView().setLayoutY(_generate.getLayoutY());
			_knife.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load1.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load1.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 3) {
					_knife.setVisible(true);
				}
				_load1.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if ((cl.getImageView().getLayoutX() + cl.getRange()
									+ cl.getImageView().getFitWidth()) > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() * 2 - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								}
								if (cl.getCount() == cl.getAtkSpeed() * 2) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200 || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
						} else if (arr.indexOf(cl) == 0 && ((cl.getImageView().getLayoutX()
								+ cl.getImageView().getFitWidth() + cl.getRange() > _Ecave.getLayoutX() + 400
								&& _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onAkPressed(MouseEvent e) {
		if (gold >= 400 && arr.size() < 10) {
			soldier cl = new soldier(8, 40, 400, 400, 510, 4000, 400, 1000);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/akman/stand.png"))), 140,
					100); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
			cl.getImageView().setLayoutX(_factory.getLayoutX() + 200);
			cl.getImageView().setLayoutY(_generate.getLayoutY());
			_ak.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load2.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load2.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 3) {
					_ak.setVisible(true);
				}
				_load2.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if (cl.getImageView().getLayoutX()
									+ cl.getRange() > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								if (arr.indexOf(cl) > 0) {
									if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) < (arr
											.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
									}
								} else {
									if (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth() < Earr.get(0)
											.getImageView().getLayoutX()) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
									}
								}
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
								}
								if (cl.getCount() == cl.getAtkSpeed()) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											if(Earr.get(0).getCost() == 100 || Earr.get(0).getCost() == 200 || Earr.get(0).getCost() == 2000)
												Earr.get(0).specialDead();
											else
												Earr.get(0).deadR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
						} else if (((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
								+ cl.getRange() > _Ecave.getLayoutX() + 400 && _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth() < _Ecave.getLayoutX()
									+ 400 && _Ecave.isVisible())
									|| (cl.getImageView().getLayoutX()
											+ cl.getImageView().getFitWidth() < _Ecastle.getLayoutX() + 650
											&& _Ecastle.isVisible())
									|| (cl.getImageView().getLayoutX()
											+ cl.getImageView().getFitWidth() < _Efactory.getLayoutX() + 600
											&& _Efactory.isVisible())) {
								if (arr.indexOf(cl) > 0
										&& (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
												.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.05);
								}
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
							}
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 5);
							}
							if (cl.getCount() == cl.getAtkSpeed()) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 5);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.05);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onTankPressed(MouseEvent e) {
		if (gold >= 5000 && arr.size() < 10) {
			soldier cl = new soldier(50, 300, 2000, 2000, 3100, 15000, 50, 1600);
			gold = gold - cl.getCost();
			cl.setImageView(
					new ImageView(new Image(getClass().getResourceAsStream("resource/soldiers/tank/stand.png"))), 300,
					450); // set view height width
			_field.getChildren().add(cl.getImageView());
			cl.getImageView().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
			cl.getImageView().setLayoutX(_factory.getLayoutX() + 200 - 100);
			cl.getImageView().setLayoutY(_generate.getLayoutY() - 110);
			_tank.setVisible(false);
			Timeline load = new Timeline(new KeyFrame(Duration.millis(1), (k) -> {
				cl.setGenerateCount();
				_load3.setScaleX((double) cl.getGenerateCount() / cl.getGenerateSpeed());
				_load3.setLayoutX(150 - 300 * (1 - (double) cl.getGenerateCount() / cl.getGenerateSpeed()));
			}));
			load.setCycleCount(cl.getGenerateSpeed());
			load.play();

			Timeline forBotton = new Timeline(new KeyFrame(Duration.millis(cl.getGenerateSpeed()), (ew) -> {
				if (!_levelup.isVisible() && time == 3) {
					_tank.setVisible(true);
				}
				_load3.setScaleX(0);
				arr.add(cl);
				Timeline clT = new Timeline(new KeyFrame(Duration.millis(1), (event) -> {
					if (cl.getHp() > 0) {
						cl.getImageView().setVisible(true);
						if (arr.indexOf(cl) > 0) {
							// if touch our soldier
							if ((cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()) > (arr
									.get(arr.indexOf(cl) - 1).getImageView().getLayoutX())) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
							}
						}
						if (Earr.size() > 0 && Earr.get(0).getHp() > 0) {
							if ((cl.getImageView().getLayoutX() + cl.getRange()
									+ cl.getImageView().getFitWidth()) > (Earr.get(0).getImageView().getLayoutX())) {
								// encounter enemy
								cl.setCount(cl.getCount() + 1);
								if (cl.getCount() == cl.getAtkSpeed() * 2 - 50) {
									cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 15);
								}
								if (cl.getCount() == cl.getAtkSpeed() * 2) {
									if (Earr.size() > 0) {
										cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 15);
										bleed(cl.getAtk(), Earr.get(0).getImageView());
										Earr.get(0).setHp(cl.getAtk());
										if(Earr.size() > 1) {
											bleed(cl.getAtk() / 2, Earr.get(1).getImageView());
											Earr.get(1).setHp(cl.getAtk()/2);
											if (Earr.get(1).getHp() <= 0) {
												gold = gold + Earr.get(1).getReward();
												exp = exp + Earr.get(1).getExp();
												getGold(Earr.get(1));
												if(Earr.get(1).getCost() == 100 || Earr.get(1).getCost() == 200 || Earr.get(1).getCost() == 2000)
													Earr.get(1).specialDead();
												else
													Earr.get(1).deadR();
												removeDead(Earr.get(1).getImageView());
												Earr.remove(Earr.get(1));
											}
										}
										if (Earr.get(0).getHp() <= 0) {
											gold = gold + Earr.get(0).getReward();
											exp = exp + Earr.get(0).getExp();
											getGold(Earr.get(0));
											Earr.get(0).beTankKilledR();
											removeDead(Earr.get(0).getImageView());
											Earr.remove(Earr.get(0));
										}
										cl.setCount(0);
									}
								}
							} else {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
							}
						} else if (arr.indexOf(cl) == 0 && ((cl.getImageView().getLayoutX()
								+ cl.getImageView().getFitWidth() + cl.getRange() > _Ecave.getLayoutX() + 400
								&& _Ecave.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Ecastle.getLayoutX() + 650 && _Ecastle.isVisible())
								|| (cl.getImageView().getLayoutX() + cl.getImageView().getFitWidth()
										+ cl.getRange() > _Efactory.getLayoutX() + 600 && _Efactory.isVisible()))) {
							// touch enemy house
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 0.04);
							cl.setCount(cl.getCount() + 1);
							if (cl.getCount() == cl.getAtkSpeed() - 50) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 15);
							}
							if (cl.getCount() == cl.getAtkSpeed() * 2) {
								cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() - 15);
								Ehp = Ehp - cl.getAtk();
								if (Ehp <= 0) {
									try {
										win();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
								cl.setCount(0);
							}
						} else {
							cl.getImageView().setLayoutX(cl.getImageView().getLayoutX() + 0.04);
						}
					}
				}));
				clT.setCycleCount(Timeline.INDEFINITE);
				clT.play();
			}));
			forBotton.setCycleCount(1);
			forBotton.play();
		}
		else {
		}
	}

	public void onClubEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("club man");
			_infocost.setText("$15");
		}
	}

	public void onSlingEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("slingshot man");
			_infocost.setText("$20");
		}
	}

	public void onDinoEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("dino rider");
			_infocost.setText("$100");
		}
	}

	public void onSwordEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("sword man");
			_infocost.setText("$50");
		}
	}

	public void onArchEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("archer");
			_infocost.setText("$70");
		}
	}

	public void onKnightEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("knight");
			_infocost.setText("$200");
		}
	}

	public void onKnifeEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("knife soldier");
			_infocost.setText("$300");
		}
	}

	public void onAkEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("AKM soldier");
			_infocost.setText("$400");
		}
	}

	public void onTankEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (arr.size() >= 10) {
			_infoname.setText("MAX");
			_infocost.setText("");
		} else {
			_infoname.setText("tank");
			_infocost.setText("$5000");
		}
	}

	public void onBackEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		_infoname.setText("Back");
		_infocost.setText("");
	}

	public void onLevelupEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		if (time == 1) {
			_infoname.setText("level up");
			_infocost.setText("need 3000exp");
		} else if (time == 2) {
			_infoname.setText("level up");
			_infocost.setText("need 20000exp");
		} else if (time == 3) {
			_infoname.setText("highest level");
			_infocost.setText("");
		}
	}

	public void onSoldierEntered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		_infoname.setText("soldier");
		_infocost.setText("");
	}

	public void onMouseExit(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.DEFAULT);
		_infoname.setText("");
		_infocost.setText("");
	}

	public void onAbility1Entered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		_infoname.setText("Vocano");
		_infocost.setText("20s");
	}
	
	public void onAbility2Entered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		_infoname.setText("Fury");
		_infocost.setText("40s");
	}
	
	public void onAbility3Entered(MouseEvent e) {
		Final.mainScene.setCursor(Cursor.HAND);
		_infoname.setText("Strafe");
		_infocost.setText("30s");
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
				if (exp >= 3000) {
					Ehp = Ehp + 200;
					EfullHp = EfullHp + 200;
					_Ecave.setVisible(false);
					_Ecastle.setVisible(true);
				}
				if (Earr.size() > 5) {
					space = 2500;
				}
				if (Earr.size() <= 5) {
					space = 2000;
				}
				if (exp <= 1000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						if(ran.nextInt(2) == 0)
							enemyClub();
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
				} else if (exp > 1000 && exp < 3000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						if(ran.nextInt(2) == 0)
							enemyDino();
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemySling();
					} else {
						switch (ran.nextInt(12)) {
						case 0:
						case 1:
							enemyClub();
							break;
						case 2:
						case 3:
							enemySling();
							break;
						case 4:
							enemyDino();
							break;
						}
					}
				}
			} else if (_Ecastle.isVisible()) {
				// time2
				if (exp >= 20000) {
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
						if(ran.nextInt(2) == 0)
							enemySword();
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
				} else if (exp > 7000 && exp < 15000 && count % space == 0 && Earr.size() < 10) {
					if (Earr.size() < 1) {
						if(ran.nextInt(2) == 0)
							enemyKnight();
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemyArch();
					} else {
						switch (ran.nextInt(12)) {
						case 0:
						case 1:
							enemySword();
							break;
						case 2:
						case 3:
							enemyArch();
							break;
						case 4:
							enemyKnight();
							break;
						}
					}
				} else if (exp <= 20000 && exp >= 15000 && Earr.size() < 10) {
					space = 2000;
					if (Earr.size() < 1) {
						if(ran.nextInt(2) == 0)
							enemyKnight();
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
						if(ran.nextInt(2) == 0)
							enemyKnife();
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
						if(ran.nextInt(2) == 0)
							enemyTank();
					} else if (Earr.size() <= 3) {
						if(ran.nextInt(2) == 0)
							enemyAk();
					} else {
						switch (ran.nextInt(10)) {
						case 0:
						case 1:
							enemyKnife();
							break;
						case 2:
						case 3:
							enemyAk();
							break;
						case 4:
							enemyTank();
							break;
						}
					}
				} else if (exp >= 50000 && Earr.size() < 10) {
					space = 2000;
					if (Earr.size() < 1) {
						if(ran.nextInt(2) == 0)
							enemyTank();
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

	protected void enemyClub() {
		soldier cl = new soldier(5, 18, 50, 15, 25, 1000, 5, 1000);
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
		soldier cl = new soldier(2, 12, 100, 20, 33, 1500, 225, 1400);
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
		soldier cl = new soldier(10, 30, 200, 100, 130, 3000, 5, 1000);
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
		soldier cl = new soldier(10, 30, 400, 50, 65, 2000, 5, 900);
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
		soldier cl = new soldier(4, 22, 500, 70, 95, 2500, 275, 1400);
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
		soldier cl = new soldier(20, 50, 1000, 200, 260, 5000, 5, 1000);
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
		soldier cl = new soldier(18, 50, 800, 300, 260, 3000, 5, 400);
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
		soldier cl = new soldier(8, 40, 1000, 400, 510, 4000, 250, 1000);
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
		soldier cl = new soldier(50, 300, 2000, 2000, 3100, 15000, 50, 1600);
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

	protected void boom(ImageView plane) {
		boolean hit = true;
		ImageView bullet = new ImageView(new Image(getClass().getResourceAsStream("resource/bullet.png")));
		bullet.setLayoutX(plane.getLayoutX());
		bullet.setLayoutY(180);
		bullet.setFitWidth(30);
		bullet.setFitHeight(91);
		_field.getChildren().add(bullet);
		ImageView explosure = new ImageView(new Image(getClass().getResourceAsStream("resource/bang.png")));
		explosure.setLayoutX(bullet.getLayoutX() - 15);
		explosure.setLayoutY(685);
		explosure.setFitHeight(100);
		explosure.setFitWidth(130);
		_field.getChildren().add(explosure);
		explosure.setVisible(false);
		Timeline Rotate = new Timeline(new KeyFrame(Duration.millis(1), (e) -> {
			bullet.setRotate(bullet.getRotate() + 1);
		}));
		Rotate.setCycleCount(5000);
		Rotate.play();
		
		Timeline bang = new Timeline(new KeyFrame(Duration.millis(50), (e)-> {
			explosure.setOpacity(explosure.getOpacity() - 0.05);
			explosure.setFitHeight(explosure.getFitHeight() + 10);
			explosure.setLayoutY(explosure.getLayoutY() - 10);
			if(explosure.getOpacity() == 0) {
				_field.getChildren().remove(explosure);
			}
		}));
		bang.setCycleCount(20);
		
		
		Timeline down = new Timeline(new KeyFrame(Duration.millis(20), (e) -> {
			bullet.setLayoutY(bullet.getLayoutY() + 12);
			if (bullet.getLayoutY() >= 760 && true) {
				_field.getChildren().remove(bullet);
				explosure.setVisible(true);
				bang.play();
				changBoolean(hit);
			}
			for (int i = 0; i < Earr.size(); i++) {
				if (bullet.getLayoutX() > Earr.get(i).getImageView().getLayoutX()
						&& bullet.getLayoutX() < Earr.get(i).getImageView().getLayoutX()
								+ Earr.get(i).getImageView().getFitWidth()
						&& bullet.getLayoutY() >= Earr.get(i).getImageView().getLayoutY() - 50
						&& bullet.getLayoutY() <= Earr.get(i).getImageView().getLayoutY()) {
					_field.getChildren().remove(bullet);
					bleed(80, Earr.get(i).getImageView());
					Earr.get(i).setHp(80);
					explosure.setVisible(true);
					bang.play();
					changBoolean(hit);
					if (Earr.get(i).getHp() <= 0) {
						gold = gold + Earr.get(i).getReward();
						exp = exp + Earr.get(i).getExp();
						getGold(Earr.get(i));
						if(Earr.get(i).getCost() == 100 || Earr.get(i).getCost() == 200 || Earr.get(i).getCost() == 2000)
							Earr.get(i).specialDead();
						else
							Earr.get(i).deadR();
						removeDead(Earr.get(i).getImageView());
						Earr.remove(Earr.get(i));
						i--;
					}
				}
			}
		}));
		down.setCycleCount(120);
		down.play();
	}

	public void bleed(int DMG, ImageView goal) {
		Label blood = new Label();
		blood.setText("" + DMG);
		blood.setTextFill(Color.RED);
		blood.setFont(new Font(20));
		_field.getChildren().add(blood);
		blood.setLayoutX(goal.getLayoutX() + goal.getFitWidth() / 2);
		blood.setLayoutY(goal.getLayoutY() + goal.getFitHeight() / 2);
		Timeline bl = new Timeline(new KeyFrame(Duration.millis(20), (a) -> {
			blood.setLayoutY(blood.getLayoutY() + 0.5);
			blood.setOpacity(blood.getOpacity() - 0.01);
		}));
		bl.setCycleCount(100);
		bl.play();
		Timeline blCtrl = new Timeline(new KeyFrame(Duration.millis(2000), (a) -> {
			_field.getChildren().remove(blood);
		}));
		blCtrl.setCycleCount(1);
		blCtrl.play();
	}

	public void getGold(soldier dead) {
		Label gd = new Label();
		gd.setText("$ +" + dead.getReward());
		gd.setTextFill(Color.YELLOW);
		gd.setFont(new Font(30));
		_field.getChildren().add(gd);
		gd.setLayoutX(dead.getImageView().getLayoutX() + dead.getImageView().getFitWidth() / 2);
		gd.setLayoutY(dead.getImageView().getLayoutY());
		Timeline reward = new Timeline(new KeyFrame(Duration.millis(100), (a) -> {
			gd.setLayoutY(gd.getLayoutY() + 0.25);
			gd.setOpacity(gd.getOpacity() - 0.1);
		}));
		reward.setCycleCount(10);
		reward.play();
		Timeline rewardCtrl = new Timeline(new KeyFrame(Duration.millis(1000), (a) -> {
			_field.getChildren().remove(gd);
		}));
		rewardCtrl.setCycleCount(1);
		rewardCtrl.play();
	}
	
	public void win() throws IOException {
		for(int i=0; i<arr.size(); i++) {
			_field.getChildren().remove(arr.get(i).getImageView());
			arr.get(i).setHp(arr.get(i).getHp());
		}
		for(int i=0; i<Earr.size(); i++) {
			_field.getChildren().remove(Earr.get(i).getImageView());
			Earr.get(i).setHp(Earr.get(i).getHp());
		}
		arr = new ArrayList<soldier>();
		Earr = new ArrayList<soldier>();
		FXMLLoader loader = new FXMLLoader(Final.class.getResource("view/win.fxml"));
		Parent win = loader.load();
		Final.mainScene = new Scene(win);
		Final.mainStage.setScene(Final.mainScene);
		Final.mainStage.setFullScreen(true);
	}
	
	public void lose() throws IOException {
		for(int i=0; i<arr.size(); i++) {
			_field.getChildren().remove(arr.get(i).getImageView());
			arr.get(i).setHp(arr.get(i).getHp());
		}
		for(int i=0; i<Earr.size(); i++) {
			_field.getChildren().remove(Earr.get(i).getImageView());
			Earr.get(i).setHp(Earr.get(i).getHp());
		}
		arr = new ArrayList<soldier>();
		Earr = new ArrayList<soldier>();
		FXMLLoader loader = new FXMLLoader(Final.class.getResource("view/lose.fxml"));
		Parent lose = loader.load();
		Final.mainScene = new Scene(lose);
		Final.mainStage.setScene(Final.mainScene);
		Final.mainStage.setFullScreen(true);
	}
	
	public void removeDead(ImageView goal) {
		Timeline remove = new Timeline(new KeyFrame(Duration.millis(700), (e) -> {
			_field.getChildren().remove(goal);
		}));
		remove.setCycleCount(1);
		remove.play();
	}
	
	public void onWinPressed(ActionEvent e) throws IOException {
		win();
	}
	
	public void onLosePressed(ActionEvent e) throws IOException{
		lose();
	}
	
	public void changBoolean(boolean temp) {
		temp = !temp;
	}
}
