package cz.kofron.school.dpo.killerbirds.model.objects.movement;

/**
 * Added by Filip Kofron on 29.11.14.
 */
public class MovementProperty
{
	public float posX = 0;
	public float posY = 0;
	public float speedX = 0;
	public float speedY = 0;
	public float angle = (float) Math.PI / 4.0f;

	public void reset()
	{
		posX = 0;
		posY = 0;
		speedX = 0;
		speedY = 0;
		angle = (float) Math.PI / 4.0f;
	}

	public MovementProperty()
	{
	}

	public MovementProperty(float posX, float posY, float speedX, float speedY, float angle)
	{
		this.posX = posX;
		this.posY = posY;
		this.speedX = speedX;
		this.speedY = speedY;
		this.angle = angle;
	}

	public MovementProperty(MovementProperty movementProperty)
	{
		posX = movementProperty.posX;
		posY = movementProperty.posY;
		speedX = movementProperty.speedX;
		speedY = movementProperty.speedY;
		angle = movementProperty.angle;
	}

	public void setFrom(MovementProperty movementProperty)
	{
		posX = movementProperty.posX;
		posY = movementProperty.posY;
		speedX = movementProperty.speedX;
		speedY = movementProperty.speedY;
		angle = movementProperty.angle;
	}

	@Override
	public String toString()
	{
		return "MovementProperty{" +
				"posX=" + posX +
				", posY=" + posY +
				", speedX=" + speedX +
				", speedY=" + speedY +
				", angle=" + angle +
				'}';
	}
}
