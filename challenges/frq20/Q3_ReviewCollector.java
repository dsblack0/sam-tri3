package frq20;

import java.util.ArrayList;

public class Q3_ReviewCollector {
  private ArrayList<Q3_ProductReview> reviewList;
  private ArrayList<String> productList;

  public Q3_ReviewCollector() {
    reviewList = new ArrayList<Q3_ProductReview>();
    productList = new ArrayList<String>();
  }

  public void addReview(Q3_ProductReview prodReview) {
    reviewList.add(prodReview);
    boolean existsNot = true;
    for (String p : productList) {
      if (p.equals(prodReview.getName())) {
        existsNot = false;
      }
    }
    if (existsNot) {
      productList.add(prodReview.getName());
    }
  }

  public int getNumGoodReviews (String prodName) {
    int numGood = 0;
    for (Q3_ProductReview p : reviewList) {
      if (p.getName().equals(prodName) && p.getReview().contains("best")) {
        numGood++;
      }
    }
    return numGood;
  }

  public void printArrays() {
    System.out.println("Review List:");
    for (Q3_ProductReview p : reviewList) {
      System.out.println(p.getName() + ": " + p.getReview());
    }
    System.out.println("Product List:");
    for (String pN : productList) {
      System.out.print(pN + " ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    Q3_ProductReview prodRev1 = new Q3_ProductReview("soap", "the best soap ever");
    Q3_ProductReview prodRev3 = new Q3_ProductReview("soap", "best");
    Q3_ProductReview prodRev2 = new Q3_ProductReview("soap", "it is ok");
    Q3_ProductReview prodRev4 = new Q3_ProductReview("cloth", "it is the best in the world");
    Q3_ReviewCollector reviews = new Q3_ReviewCollector();
    reviews.addReview(prodRev1);
    reviews.printArrays();
    reviews.addReview(prodRev2);
    reviews.printArrays();
    reviews.addReview(prodRev3);
    reviews.addReview(prodRev4);
    reviews.printArrays();
    System.out.println();
    System.out.println("Number of good soap reviews: " + reviews.getNumGoodReviews("soap"));
  }
}