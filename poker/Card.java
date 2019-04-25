public class Card implements Comparable<Card>
{
        //only three face cards K, Q, J
	public int face;
	
	
	
	public int compareTo(Card o) 
	{
	     if (this.face == (o.face))
	            return 0;
	     else if ((this.face) > (o.face))
	            return 1;
	     else
	           return -1;
    }

    public int display(Card o)
    {
        return o.face;
    }
    
}
