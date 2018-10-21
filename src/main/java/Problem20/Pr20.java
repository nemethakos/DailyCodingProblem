package Problem20;

public class Pr20 {

	public static Element findIntersection(Element list1, Element list2) {

		// m always the longer or equal
		if (list2.length() > list1.length()) {
			Element tmp = list1;
			list1 = list2;
			list2 = tmp;
		}

		int start = list1.length() - list2.length();

		list1 = list1.skip(start);

		while (list1.getNext() != list2.getNext()) {
			list1 = list1.getNext();
			list2 = list2.getNext();
		}

		return list1.getNext();
	}

	public static void main(String... args) {

		Element common = new Element(9).add(new Element(10));

		System.out.println("common elements: " + common + ", length: " + common.length());

		Element list1 = new Element(1)//
				.add(new Element(2))//
				.add(new Element(3))//
				.add(new Element(4))//
				.add(new Element(5))//
				.add(new Element(6))//
				.add(new Element(7))//
				.add(new Element(8))//
				.add(common);

		Element list2 = new Element(1)//
				.add(new Element(2))//
				.add(common);

		Element list3 = new Element(1)//
				.add(new Element(2))//
				.add(new Element(3))//
				.add(new Element(4))//
				.add(new Element(5))//
				.add(new Element(6))//
				.add(new Element(7))//
				.add(new Element(8))//
				.add(common);

		System.out.println("list1: " + list1 + ", length: " + list1.length());
		System.out.println("list2: " + list2 + ", length: " + list2.length());

		System.out.println("intersection: " + findIntersection(list1, list2));
		System.out.println("intersection: " + findIntersection(list2, list1));
		// same length test
		System.out.println("intersection: " + findIntersection(list1, list3));
	}

}
