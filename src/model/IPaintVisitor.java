package model;

import csc2a.model.Rectangle;
import csc2a.model.Triangle;

public interface IPaintVisitor {
	void paint(Rectangle rectangle);
	void paint(Triangle triangle);

}
