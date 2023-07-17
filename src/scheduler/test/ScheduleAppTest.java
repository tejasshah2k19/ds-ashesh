package scheduler.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import scheduler.DeadlineEngineImpl;

public class ScheduleAppTest {

	DeadlineEngineImpl schedule;

	@Before
	public void setup() {
		this.schedule = new DeadlineEngineImpl();
	}

	void addTwoSchedule() {
		Calendar c = Calendar.getInstance();
		Long now = c.getTimeInMillis();
		c.add(Calendar.MINUTE, 10);
		Long min_10 = c.getTimeInMillis();
		Long s1 = this.schedule.schedule(now);
		Long s2 = this.schedule.schedule(min_10);
	}
	
	@Test
	public void testScheduleAdd() throws Exception {

		addTwoSchedule();
		assertEquals(2, this.schedule.size());

	}

	@Test
	public void testScheduleCancel() {
		Calendar c = Calendar.getInstance();
		Long now = c.getTimeInMillis();
		c.add(Calendar.MINUTE, 10);
		Long min_10 = c.getTimeInMillis();
		Long s1 = this.schedule.schedule(now);
		Long s2 = this.schedule.schedule(min_10);
		assertEquals(true, this.schedule.cancel(s2));
		assertEquals(1, this.schedule.size());
	}

	@Test
	public void testInvalidScheduleCancel() {
		addTwoSchedule();
		assertEquals(false, this.schedule.cancel(123456));
		assertEquals(2, this.schedule.size());
	}
	
	@Test
	public void testSchedulePoll() {
		Calendar c = Calendar.getInstance();
		Long now = c.getTimeInMillis();
		c.add(Calendar.MINUTE, 10);
		Long min_10 = c.getTimeInMillis();
		Long s1 = this.schedule.schedule(now);
		Long s2 = this.schedule.schedule(min_10);
		Long s3 = this.schedule.schedule(min_10);
	
		c.add(Calendar.MINUTE, 20);
		Long min_20 = c.getTimeInMillis();
		Long s4 = this.schedule.schedule(min_20);
		Long s5 = this.schedule.schedule(min_20);
		
		
		assertEquals(5, this.schedule.size());
		assertEquals(2,this.schedule.poll(min_10, null, 3));
		assertNotEquals(2, this.schedule.poll(min_20, null, 1));
	}


}
