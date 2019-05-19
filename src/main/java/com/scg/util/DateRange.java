
package com.scg.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
* Class to the Personal Data.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class DateRange {
    private LocalDate startDate;
    private LocalDate endDate;
    
    /**
	  * Date Range constructor.
	  * @param startDate, Start Date
	  * @param endDate. End Date
	  */ 
    public DateRange( LocalDate startDate, LocalDate endDate ) {
    	this.startDate = startDate;
    	this.endDate = endDate;
    }
    
    /**
	  * Date Range constructor to set start date to first day of the month and set end date to last day of the month.
	  * @param month, Month
	  * @param year. Year
	  */ 
    public DateRange( Month month, int year ) {
    	startDate = LocalDate.of(year,month,01);
    	endDate = LocalDate.of(year,month,startDate.lengthOfMonth());
    }
    
    
    public DateRange( String start, String end ) {
    	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY-MM-DD");
    	startDate = LocalDate.parse(start,formatter);
    	endDate = LocalDate.parse(end,formatter);
    }
    
    /**
     * Get Start Date.
     * @return startDate - Start Date
     */
    public LocalDate getStartDate() {
    	return startDate;
    }
    
    /**
     * Get End Date.
     * @return endDate - End Date
     */
    public LocalDate getEndDate() {
    	return endDate;
    }
    
    
    public boolean isInRange( LocalDate date ) {
    	LocalDate currentDate = date;
    	Boolean inRange = false;
    	if(currentDate.compareTo(startDate)>=0 && currentDate.compareTo(endDate)<=0) inRange=true;
    	
    	return inRange;
    }
}
