package entities.base;

import exception.IllegalValueException;

public interface Upgradeable {
	public abstract boolean update() throws IllegalValueException;
}
