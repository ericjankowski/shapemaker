package com.erj.shapemaker.shapes;

public class Triangle {
	
	private int sideLength;

	public Triangle(){
		this.sideLength = 1;
	}
	
	public Triangle(int sideLength) {
		this.sideLength = sideLength;
	}

	public boolean equals(Object o){
		if(!(o instanceof Triangle)){
			return false;
		}else{
			Triangle other = null;
			try{
				other = (Triangle) o;
			}catch(Exception e){
				return false;
			}
			if(other.getSideLength() == this.getSideLength()){
				return true;
			}
		}
		return false;
	}

	public int getSideLength() {
		return sideLength;
	}

	public int getNumberOfSides() {
		return 3;
	}
}
