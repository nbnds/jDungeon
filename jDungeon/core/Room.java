package core;

import java.util.Observer;

public abstract class Room implements Observer{
	Sides Entrance;
	Sides Exit;
	void addMob(){};
	void addItem(){};
	void getDescription(){
	
	}
	void onEnter(Player p){
		
		p.look_around();
	};
	public Room(){
		
	}
}
