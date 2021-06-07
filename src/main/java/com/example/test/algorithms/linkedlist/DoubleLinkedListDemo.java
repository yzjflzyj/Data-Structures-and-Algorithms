package com.example.test.algorithms.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		//
		HeroNode2 hero1 = new HeroNode2(1, "关羽", "云长");
		HeroNode2 hero2 = new HeroNode2(2, "张飞", "翼德");
		HeroNode2 hero3 = new HeroNode2(3, "赵云", "子龙");
		HeroNode2 hero4 = new HeroNode2(4, "马超", "孟起");
		//创建双链表
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);

		//展示双链表
		doubleLinkedList.list();
		
		//更新节点
		HeroNode2 newHeroNode = new HeroNode2(4, "黄忠", "汉升");
		doubleLinkedList.update(newHeroNode);
		System.out.println("更新后的双链表为");
		doubleLinkedList.list();
		
		//删除节点
		doubleLinkedList.del(3);
		System.out.println("删除节点后的双链表为");
		doubleLinkedList.list();
		
		
		
	}

}

// 双链表
class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "", "");

	//获取双链表的头节点
	public HeroNode2 getHead() {
		return head;
	}

	// 展示双链表
	public void list() {
		// 除头节点外链表为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			//遍历打印各个节点
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// 双链表末尾添加节点
	public void add(HeroNode2 heroNode) {

		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	//更新节点
	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("双链表为空");
			return;
		}

		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("没有找到编号为%d 的节点\n", newHeroNode.no);
		}
	}

	//删除节点
	public void del(int no) {

		if (head.next == null) {
			System.out.println("双链表为空");
			return;
		}

		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.pre.next = temp.next;
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("没有找到编号为%d的节点\n", no);
		}
	}

}

// 对象HeroNode2
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;

	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
