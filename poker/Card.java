public class Card implements Comparable<Card>
{
  // I.V.s are suit and rank
	public int face;
	//public int rank;
	
	//@Override
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