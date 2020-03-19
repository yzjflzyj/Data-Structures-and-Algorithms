package com.example.test.linkedlist;

public class Josepfu {

	public static void main(String[] args) {
		//单向环形链表
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(125);
		circleSingleLinkedList.showBoy();

		circleSingleLinkedList.countBoy(10, 20, 125);
	}

}

class CircleSingleLinkedList {

	private Boy first = null;

	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("单向环形链表长度必须不小于1");
			return;
		}
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	//遍历展示单向环形链表
	public void showBoy() {
		if (first == null) {
			System.out.println("双链表为空");
			return;
		}
		//遍历展示单向环形链表
		Boy curBoy = first;
		while (true) {
			System.out.printf("节点编号为%d\n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	// 出圈,即删除节点
	/**
	 * 
	 * @param startNo
	 *            从第startNo个开始
	 * @param countNum
	 *            数countNum个
	 * @param nums
	 *            环形的总个数
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("链表无法提取");
			return;
		}
		//第一个节点
		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//helper指向最后一个节点,first指向第一个节点
		//数startNo个节点
		for(int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		while(true) {
			//只有一个节点
			if(helper == first) {
				break;
			}
			//以此从第一个节点算作1,因此要移动countNum - 1次指针
			for(int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//此时的first即是要删除的节点
			System.out.printf("要删除的是编号是%d的节点\n", first.getNo());
			//first前移一个,helper指向first
			first = first.getNext();
			helper.setNext(first);
			
		}
		System.out.printf("只剩下唯一一个编号为%d的节点\n", first.getNo());
		
	}
}


class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}
