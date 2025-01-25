<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:background="#FFFFFF">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <!-- Welcome Message -->
        <TextView
            android:id="@+id/welcomeMessage"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello Rebecca!"
            android:textSize="24sp"
            android:textStyle="bold"
            android:layout_marginBottom="16dp" />

        <!-- Donation List -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Sudan Outreach"
            android:textSize="18sp"
            android:textColor="#FF9800"
            android:layout_marginBottom="4dp" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="The kids in Sudan can again use the food they received from donors on Jan 15, 2025."
            android:textSize="14sp"
            android:textColor="#666666"
            android:layout_marginBottom="16dp" />

        <!-- Summary Section -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:weightSum="2"
            android:background="#F5EFE7"
            android:padding="16dp"
            android:layout_marginBottom="16dp">

            <!-- Monthly Report -->
            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="MONTHLY REPORT"
                    android:textSize="16sp"
                    android:textColor="#333333"
                    android:textStyle="bold"
                    android:layout_marginBottom="4dp" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="November"
                    android:textSize="14sp"
                    android:textColor="#666666" />
            </LinearLayout>

            <!-- Donations Summary -->
            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="DONATIONS: 2.6K+"
                    android:textSize="16sp"
                    android:textColor="#333333"
                    android:textStyle="bold"
                    android:layout_marginBottom="4dp" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="ACTIVE DONORS: 1.2K+"
                    android:textSize="14sp"
                    android:textColor="#666666" />
            </LinearLayout>
        </LinearLayout>
    </LinearLayout>
</ScrollView>
