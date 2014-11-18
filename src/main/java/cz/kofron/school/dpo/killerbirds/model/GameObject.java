package cz.kofron.school.dpo.killerbirds.model;

/**
 * @author Filip Kofron
 */
public abstract class GameObject implements Comparable
{
	protected static long counter = 0;
	protected long id = 0;
	protected float x;
	protected float y;
	protected float r;
	protected long timeCreated = System.currentTimeMillis();
	protected String name;

	public GameObject(float x, float y, float r, String name)
	{
		this.x = x;
		this.y = y;
		this.r = r;
		this.name = name;

		id = counter++;
	}

	public boolean collidesWith(GameObject gameObject)
	{
		float rSum = r + gameObject.r;
		float xd = x - gameObject.x;
		float yd = y - gameObject.y;

		float dist = (float) Math.sqrt(xd * xd + yd * yd);

		return dist < rSum;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public void move(float dx, float dy)
	{
		x += dx;
		y += dy;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public float getR()
	{
		return r;
	}

	public void setR(float r)
	{
		this.r = r;
	}

	public long getId()
	{
		return id;
	}

	public abstract void update();

	public String getName()
	{
		return name;
	}

	@Override
	public int compareTo(Object o)
	{
		long res = id - ((GameObject) o).id;

		if(res < 0)
		{
			return -1;
		}
		else
		{
			if(res > 0)
			{
				return 1;
			}
		}
		return 0;
	}

	public long getTimeCreated()
	{
		return timeCreated;
	}
}
