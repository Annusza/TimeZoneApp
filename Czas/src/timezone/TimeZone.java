package timezone;


public class TimeZone {
	
	protected String abbreviation;
    protected String client_ip;
    protected String datetime;
    protected Integer day_of_week;
    protected Integer day_of_year;
    protected Boolean dst;
    protected Integer dst_offset;
    protected String timezone;
    protected Integer unixtime;
    protected String utc_datetime;
    protected String utc_offset;
    protected Integer week_number;
    
	public String getAbbreviation() {
	
		return abbreviation;
	}
	
	public void setAbbreviation(String abbreviation) {
	
		this.abbreviation = abbreviation;
	}
	
	public String getClient_ip() {
	
		return client_ip;
	}
	
	public void setClient_ip(String client_ip) {
	
		this.client_ip = client_ip;
	}
	
	public String getDatetime() {
	
		return datetime;
	}
	
	public void setDatetime(String datetime) {
	
		this.datetime = datetime;
	}
	
	public Integer getDay_of_week() {
	
		return day_of_week;
	}
	
	public void setDay_of_week(Integer day_of_week) {
	
		this.day_of_week = day_of_week;
	}
	
	public Integer getDay_of_year() {
	
		return day_of_year;
	}
	
	public void setDay_of_year(Integer day_of_year) {
	
		this.day_of_year = day_of_year;
	}
	
	public Boolean getDst() {
	
		return dst;
	}
	
	public void setDst(Boolean dst) {
	
		this.dst = dst;
	}
	
	public Integer getDst_offset() {
	
		return dst_offset;
	}
	
	public void setDst_offset(Integer dst_offset) {
	
		this.dst_offset = dst_offset;
	}
	
	public String getTimezone() {
	
		return timezone;
	}
	
	public void setTimezone(String timezone) {
	
		this.timezone = timezone;
	}
	
	public Integer getUnixtime() {
	
		return unixtime;
	}
	
	public void setUnixtime(Integer unixtime) {
	
		this.unixtime = unixtime;
	}
	
	public String getUtc_datetime() {
	
		return utc_datetime;
	}
	
	public void setUtc_datetime(String utc_datetime) {
	
		this.utc_datetime = utc_datetime;
	}
	
	public String getUtc_offset() {
	
		return utc_offset;
	}
	
	public void setUtc_offset(String utc_offset) {
	
		this.utc_offset = utc_offset;
	}
	
	public Integer getWeek_number() {
	
		return week_number;
	}
	
	public void setWeek_number(Integer week_number) {
	
		this.week_number = week_number;
	}
	

}
