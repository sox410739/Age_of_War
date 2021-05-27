package ce1002.Final.s107502533;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class soldier {
	private int _atk;
	private int _hp;
	private int _exp;
	private int _cost;
	private int _reward;
	private int _generateSpeed;
	private int _range;
	private ImageView _IM;
	private int count = 0;
	private int generateCount = 0;
	private int atkSpeed;
	
	public soldier(int atk, int hp, int exp, int cost, int reward, int generateSpeed, int range, int AS) {
		_atk = atk;
		_hp = hp;
		_exp = exp;
		_cost = cost;
		_reward = reward;
		_generateSpeed = generateSpeed;
		_range = range;
		atkSpeed = AS;
	}
	
	public int getAtk() {
		return _atk;
	}
	
	public int getHp() {
		return _hp;
	}
	
	public int getExp() {
		return _exp;
	}
	
	public int getCost() {
		return _cost;
	}
	
	public int getReward() {
		return _reward;
	}
	
	public int getGenerateSpeed() {
		return _generateSpeed;
	}
	
	public int getRange() {
		return _range;
	}
	
	public void setHp(int i) {
		_hp = _hp - i;
	}
	
	public void setImageView(ImageView i, int H, int W) {
		_IM = i;
		_IM.setVisible(false);
		_IM.setFitHeight(H);
		_IM.setFitWidth(W);
	}
	
	public ImageView getImageView() {
		return _IM;
	}
	
	public void setAtk(int temp) {
		_atk = temp;
	}
	
	public int getCount() {
		if(count > atkSpeed * 2) {
			count = count % (atkSpeed * 2) ;
		}
		return count;
	}
	
	public void setCount(int temp) {
		count = temp;
	}
	
	public int getGenerateCount() {
		return generateCount;
	}
	
	public void setGenerateCount() {
		generateCount = generateCount + 1;
	}
	
	public int getAtkSpeed() {
		return atkSpeed;
	}
	
	public void setAtkSpeed(int temp) {
		atkSpeed = temp;
	}
	
	public void larger() {
		Timeline larger = new Timeline(new KeyFrame(Duration.millis(200), (e2) -> {
			_IM.setScaleX(_IM.getScaleX() + 0.05);
			_IM.setScaleY(_IM.getScaleY() + 0.05);
		}));
		larger.setCycleCount(5);
		larger.play();
		
		Timeline small = new Timeline(new KeyFrame(Duration.millis(20000), (e2) -> {
			Timeline smaller = new Timeline(new KeyFrame(Duration.millis(200), (e3) -> {
				_IM.setScaleX(_IM.getScaleX() - 0.05);
				_IM.setScaleY(_IM.getScaleY() - 0.05);
			}));
			smaller.setCycleCount(5);
			smaller.play();
			_atk = _atk / 2;
			atkSpeed = atkSpeed * 2;
		}));
		small.setCycleCount(1);
		small.play();
	}
	
	public void deadL() {
		Timeline dead = new Timeline(new KeyFrame(Duration.millis(5), (e) -> {
			_IM.setRotate(_IM.getRotate() - 1);
			_IM.setLayoutY(_IM.getLayoutY() + 0.5);
			_IM.setLayoutX(_IM.getLayoutX() - 0.3);
		}));
		dead.setCycleCount(90);
		dead.play();
	}
	
	public void deadR() {
		Timeline dead = new Timeline(new KeyFrame(Duration.millis(5), (e) -> {
			_IM.setRotate(_IM.getRotate() + 1);
			_IM.setLayoutY(_IM.getLayoutY() + 0.5);
			_IM.setLayoutX(_IM.getLayoutX() + 0.3);
		}));
		dead.setCycleCount(90);
		dead.play();
	}
	
	public void beTankKilledR() {
		Timeline dead = new Timeline(new KeyFrame(Duration.millis(5), (e) -> {
			_IM.setRotate(_IM.getRotate() + 1);
			_IM.setLayoutY(_IM.getLayoutY() + 0.5);
			_IM.setLayoutX(_IM.getLayoutX() + 6);
		}));
		dead.setCycleCount(90);
		dead.play();
	}
	
	public void beTankKilledL() {
		Timeline dead = new Timeline(new KeyFrame(Duration.millis(5), (e) -> {
			_IM.setRotate(_IM.getRotate() - 1);
			_IM.setLayoutY(_IM.getLayoutY() + 0.5);
			_IM.setLayoutX(_IM.getLayoutX() - 6);
		}));
		dead.setCycleCount(90);
		dead.play();
	}
	
	public void specialDead() {
		Timeline dead = new Timeline(new KeyFrame(Duration.millis(5), (e) -> {
			_IM.setLayoutY(_IM.getLayoutY() + 0.5);
			_IM.setOpacity(_IM.getOpacity() - 0.01);
			_IM.setFitHeight(_IM.getFitHeight() - 0.5);
		}));
		dead.setCycleCount(90);
		dead.play();
	}
	
}
