
// Example Queue data structure used in coursework M.S. Operations Research

class QueueNode<T>
{
	T data; // data for node
	QueueNode<T> nextNode; // link to next node in queue

	// default constructor create queue with object, set next node to null
	QueueNode(T object)
	{
		this(object, null); 
	}

	// constructor create QueueNode<T> with object, node as nextNode
	QueueNode(T object, QueueNode<T> node)
	{
		data = object;
		nextNode = node;
	}

	// get T data from object
	T getData()
	{
		return data;
	}

	// get next node in queue
	QueueNode<T> getNext()
	{
		return nextNode;
	}
}

public class Queue<T>
{
	private QueueNode<T> firstNode; // first node in queue
	private QueueNode<T> lastNode; // last node in queue
	private String name; // queue name
	private int nodeCount = 0; // track number of nodes

	// constructor creates queue with default name "queue"
	public Queue()
	{
		this("queue");
	}

	// constructor creates queue with name queueName
	public Queue(String queueName)
	{
		name = queueName;
		firstNode = lastNode = null;
	}

	// method to add node in back of queue
	public void enqueue(T insertItem)
	{
		if (isEmpty()) // test if queue is empty
		{
			firstNode = lastNode = new QueueNode<T>(insertItem); // first node to add is first and last in queue
			nodeCount++;
		}
		else
		{
			lastNode = lastNode.nextNode = new QueueNode<T>(insertItem); // add node to last in queue
			nodeCount++;
		}

	}

	public T dequeue() throws EmptyListException
	{
		if (isEmpty()) // throw exception if queue is empty
			throw new EmptyListException(name);
		T removedItem = firstNode.data; // get data from removed node

		// update firstNode
		if (firstNode == lastNode)
		{
			firstNode = lastNode = null;
			nodeCount--;
		}
		else
		{
			firstNode = firstNode.nextNode;
			nodeCount--;
		}

		return removedItem;
	}

	public T getNode(int nodeNumber)
	{
		QueueNode<T> current = firstNode;

		if (nodeNumber > nodeCount)
			return lastNode.nextNode.data;

		for (int i = 1; i < nodeNumber; i++)
			current = current.nextNode;
		return current.data;
	}

	public int getCount()
	{
		// get count of nodes in queue
		return nodeCount;
	}

	public boolean isEmpty()
	{
		return firstNode == null; // return true if list is empty
	}

	public void print()
	{
		// print nodes in queue
		if (isEmpty())
		{
			System.out.printf("%s is empty\n", name);
			return;
		}

		System.out.println(firstNode.data);
		System.out.println(lastNode.data);

		System.out.printf("The %s is: ", name);
		QueueNode<T> current = firstNode;

		while (current != lastNode.nextNode)
		{
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}

		System.out.println();
	}
}
