package com.skynet.retailscm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/*
 * 
 * 
SmartList实现List接口，继承BaseEntity。

可以统计操作类型，如果从中间插入和删除过多，就改成LinkedList，以此来改善性能，而且在构造改List的时候无须初始化一个数组

继承BaseEntity之后就可以使用actionList和message了。

actionList - 构造界面上可以操作的按钮更容易了。
message - 有什么要告诉前台，更容易
count，对列表条数进行统计
toRemoveList，保存将要删除的元素
facetList，动态过滤器列表
 * 
 * */
public class SmartList<E  extends BaseEntity> extends BaseEntity implements List<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<E> smartList;
	
	private long counter = 0;
	private static final long SWITCH_COUNT=100000;
	protected void tryToKeepArrayListList(){
		--counter;
	}
	
	protected void tryToSwithToLinkedList(){
		
		++counter;
		
		if(counter > SWITCH_COUNT){
			
			List<E> tempList = new LinkedList<E>();
			tempList.addAll(smartList);
			
			smartList = tempList;
		}
		
		
	}
	
	protected void ensureSmartList(){
		if(smartList!=null){
			return;
		}
		smartList = new ArrayList<E>();
	}
	public SmartList(){
		super();
		
	}
	public int size() {
		ensureSmartList();
		return smartList.size();
	}

	public boolean isEmpty() {
		ensureSmartList();
		return smartList.isEmpty();
	}

	public boolean contains(Object o) {
		ensureSmartList();
		return smartList.contains(o);
	}

	public Iterator<E> iterator() {
		ensureSmartList();
		return smartList.iterator();
	}

	public Object[] toArray() {
		ensureSmartList();
		return smartList.toArray();
	}

	public <T> T[] toArray(T[] a) {
		ensureSmartList();
		tryToKeepArrayListList();// 有利于使用ArrayList的操作，则减少切换到LinkedList的机会
		return smartList.toArray(a);
	}

	public boolean add(E e) {
		ensureSmartList();
		return smartList.add(e);
	}

	public boolean remove(Object o) {
		ensureSmartList();		
		return smartList.remove(o);
	}
	
	
	public boolean planToRemove(E o) {
		ensureSmartList();
		this.addToRemoveList(o);
		return smartList.remove(o);
	}
	public boolean containsAll(Collection<?> c) {
		ensureSmartList();
		return smartList.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c) {
		ensureSmartList();
		return smartList.addAll(c);
	}
	private int totalCount = 0;
	public int getTotalCount(){
		
		if(totalCount<size()){
			return size();
		}
		return totalCount;
		
	}
	
	
	
	public void setTotalCount(int newTotalCount){
		if(newTotalCount <= 0){
			return;
		}
		this.totalCount = newTotalCount;
	}
	
	protected List<BaseEntity> pagesOf(int loadedTotalSize ,int currentPage){

		List<BaseEntity> pages = new Pagination(loadedTotalSize).render(currentPage);
		return pages;

	}
	public List<BaseEntity> getPages(){
		
		
		List<BaseEntity> pages =  pagesOf(this.getTotalCount(),this.getCurrentPageNumber());
		
		if(pages.size()<2){
			return new ArrayList<BaseEntity>();
		}
		return pages;
	}
	
	private int currentPageNumber = 1;
	public void setCurrentPageNumber(int number){
		if(number<1){
			return;
		}
		currentPageNumber = number;
	}
	public int getCurrentPageNumber() {
		// TODO Auto-generated method stub
		return currentPageNumber;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		if(c == null){
			return false;
		}
		ensureSmartList();
		if(index < this.size()){
			//如果index不在最后一个位置上，则是从头或者中间开始设置，可以开始试着往Linkedlist转
			this.tryToSwithToLinkedList();
		}
		return smartList.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		ensureSmartList();
		return smartList.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		ensureSmartList();
		return smartList.retainAll(c);
	}

	public void clear() {
		ensureSmartList();
		smartList.clear();
	}

	public boolean equals(Object o) {
		ensureSmartList();
		return smartList.equals(o);
	}

	public int hashCode() {
		ensureSmartList();
		return smartList.hashCode();
	}

	public E get(int index) {
		ensureSmartList();
		tryToKeepArrayListList();// 有利于使用ArrayList的操作，则减少切换到LinkedList的机会
		return smartList.get(index);
	}

	public E set(int index, E element) {
		ensureSmartList();
		if(index < this.size()){
			//如果index不在最后一个位置上，则是从头或者中间开始设置，可以开始试着往Linkedlist转
			this.tryToSwithToLinkedList();
		}
		return smartList.set(index, element);
	}

	public void add(int index, E element) {
		ensureSmartList();
		if(index < this.size()){
			//如果index不在最后一个位置上，则是从头或者中间开始设置，可以开始试着往Linkedlist转
			this.tryToSwithToLinkedList();
		}
		smartList.add(index, element);
	}

	public E remove(int index) {
		
		ensureSmartList();
		if(index < this.size()){
			//如果index不在最后一个位置上，则是从头或者中间开始删除，可以开始试着往Linkedlist转
			this.tryToSwithToLinkedList();
		}
		return smartList.remove(index);
	}

	public int indexOf(Object o) {
		ensureSmartList();
		return smartList.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		ensureSmartList();
		return smartList.lastIndexOf(o);
	}

	public ListIterator<E> listIterator() {
		ensureSmartList();
		return smartList.listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		ensureSmartList();
		tryToKeepArrayListList();// 有利于使用ArrayList的操作，则减少切换到LinkedList的机会
		return smartList.listIterator(index);
	}

	public List<E> subList(int fromIndex, int toIndex) {
		ensureSmartList();
		tryToKeepArrayListList();// 有利于使用ArrayList的操作，则减少切换到LinkedList的机会
		return smartList.subList(fromIndex, toIndex);
	}
	public SmartList<E> subListOf(int fromIndex, int toIndex) {
		ensureSmartList();
		tryToKeepArrayListList();// 有利于使用ArrayList的操作，则减少切换到LinkedList的机会
		
		SmartList<E> newSmartList = new SmartList<E>();
		newSmartList.addAll(smartList.subList(fromIndex, toIndex));
		return newSmartList;
	}
	
	private List<E> toRemoveList;
	public void addToRemoveList(E e) {
		ensureToRemoveList();
		toRemoveList.add(e);
		
	}
	protected void removeToRemoveList(E e) {
		if(toRemoveList ==null){
			return;
		}
		
		toRemoveList.remove(e);
		
	}
	private void ensureToRemoveList() {
		if(toRemoveList !=null){
			return;
		}
		toRemoveList = new ArrayList<E>();
		
	}

	public SmartList<E> getToRemoveList() {
		if(toRemoveList == null){
			return null;
		}
		SmartList<E> newSmartList = new SmartList<E>();
		newSmartList.addAll(toRemoveList);
		return newSmartList;
	}
	
}






