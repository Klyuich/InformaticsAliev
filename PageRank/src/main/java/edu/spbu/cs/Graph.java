package edu.spbu.cs;

public interface Graph {
	public int getSize();
	public Vertex get(int i);
	public void countPageRank();//Интересно, этот метод вообще здесь нужен?
	public double getPageRank(int i);
}
