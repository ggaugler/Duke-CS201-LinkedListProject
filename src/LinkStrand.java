//Geoff Gaugler
//Ashley Lanzas

public class LinkStrand implements IDnaStrand {

	private class Node//Node class
	{
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}	
	//class variables
	private Node myFirst, myLast;
	private long mySize;
	private int myAppends;
	private int myIndex;
	private int myLocalIndex;
	private Node myCurrent;
	
	public LinkStrand() { //sets default value to an empty string
		this("");
	}
	
	public LinkStrand(String a) { //calls initialize method
		initialize(a);
	}
	
	@Override
	public long size() { //overridden size method returns the size of LinkStrand
		return mySize;
	}
	
	@Override //initializes variables for the object LinkStrand
	public void initialize(String source) 
	{
		myFirst = new Node(source);
		myLast = myFirst;
		mySize = myFirst.info.length();
		myAppends = 0;
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}
	
	@Override
	public IDnaStrand getInstance(String source){
		return new LinkStrand(source);
	}
	
	@Override
	public IDnaStrand append(String dna)
	{
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize += myLast.info.length();
		myAppends += 1;
		return this;
	}
	
	private void appendToFront(String dna)
	{
		Node temp = new Node(dna);
		this.mySize += temp.info.length();
		temp.next = myFirst;
		myFirst = temp;
	}
	
	@Override
	public IDnaStrand reverse()
	{
		Node guy = myFirst;
		LinkStrand guy1 = new LinkStrand();
		while (guy != null)
		{
			StringBuilder guy2 = new StringBuilder(guy.info);
			String x = guy2.reverse().toString();
			guy1.appendToFront(x);
			guy = guy.next;	
		}
		return guy1;
	}
	
	@Override 
	public int getAppendCount(){
		return myAppends;
	}
	
	@Override
	public char charAt(int index)
	{
		if(0 > index || myIndex >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		if (myIndex >= index)
		{
			myIndex = 0;
			myLocalIndex = 0;
			myCurrent = myFirst;
		}
		while (index != myIndex)
		{
			myIndex += 1;
			myLocalIndex += 1;
			if (myCurrent.next != null && myCurrent.info.length()<= myLocalIndex) {
				myCurrent = myCurrent.next;
				myLocalIndex = 0;
			}	
		}
		return myCurrent.info.charAt(myLocalIndex);
	}
	
	@Override
	public String toString() 
	{
		Node list = myFirst;
		StringBuilder guy = new StringBuilder();
		while(list.next != null)
		{
			guy.append(list.info);
			list = list.next;
		}
		guy.append(list.info);
		return guy.toString();
	}	
}
	
	
