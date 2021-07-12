import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeObjekte {

  public static void main( String... strings ) {
//    objekteErzeugen();

//     getter();

//     with();

//     truncate();

//     timeZone();

//     periods();

//     durations();

//     kompatibilitaet();
  }

  public static void objekteErzeugen() {
    LocalDateTime timePoint = LocalDateTime.now();
    System.out.println( timePoint );

    LocalDate date = LocalDate.of( 2017, 05, 01 );
    System.out.println( date );

    LocalTime time = LocalTime.of( 16, 30 );
    System.out.println( time );

    LocalTime time2 = LocalTime.parse( "16:29:59" );
    System.out.println( time2 );
  }

  public static void getter() {
    LocalDateTime timePoint = LocalDateTime.now();
    System.out.println( "Zeitpunkt: " + timePoint );

    LocalDate theDate = timePoint.toLocalDate();
    System.out.println( "Datum: " + theDate );

    Month month = timePoint.getMonth();
    System.out.println( "Monat: " + month );

    int day = timePoint.getDayOfMonth();
    System.out.println( "Tag (Monat): " + day );

    int dayOfYear = timePoint.getDayOfYear();
    System.out.println( "Tag (Jahr): " + dayOfYear );

    int second = timePoint.getSecond();
    System.out.println( "Sekunde: " + second );

  }

  public static void with() {
    LocalDateTime timePoint = LocalDateTime.now();
    System.out.println( "Zeitpunkt: " + timePoint );

    LocalDateTime thePast = timePoint.withDayOfMonth( 10 ).withYear( 2010 );
    System.out.println( "Vergangenheit: " + thePast );

    LocalDateTime another = thePast.plusWeeks( 3 ).plus( 3, ChronoUnit.WEEKS );
    System.out.println( "andere Vergangenheit: " + another );

    LocalDateTime foo = timePoint.with( TemporalAdjusters.lastDayOfMonth() );
    System.out.println( "Zeitpunkt (letzter Tag im Monat): " + foo );

    LocalDateTime bar = timePoint.with( TemporalAdjusters.previousOrSame( DayOfWeek.WEDNESDAY ) );
    System.out.println( "Zeitpunkt (letzter Mittwoch): " + bar );

    LocalDateTime now = thePast.with( LocalTime.now() );
    System.out.println( "Zeitpunkt (aktualisierte Zeit): " + now );
  }

  public static void truncate() {
    LocalDateTime timePoint = LocalDateTime.now();
    System.out.println( "Zeitpunkt: " + timePoint );

    LocalTime time = timePoint.toLocalTime();
    System.out.println( "Zeit: " + time );

    LocalTime ohneSec = time.truncatedTo( ChronoUnit.MINUTES );
    System.out.println( "Zeit (ohne Sekunden): " + ohneSec );
  }

  public static void timeZone() {
    ZoneId id = ZoneId.of( "Europe/Berlin" );
    System.out.println( "Zeitzone: " + id );
    ZonedDateTime zoned = ZonedDateTime.of( LocalDateTime.now(), id );
    System.out.println( "Zeitpunkt mit Zone: " + zoned );

    OffsetTime offsetTime = OffsetTime.now();
    System.out.println( "Zeit mit Offset: " + offsetTime );

    OffsetTime sameTimeDifferentOffset = offsetTime.withOffsetSameInstant( ZoneOffset.UTC );
    System.out.println( "Zeit mit Offset (Zeit in Abhängigkeit des Offstes berechnet): "
            + sameTimeDifferentOffset );

    OffsetTime changeTimeWithNewOffset = offsetTime.withOffsetSameLocal( ZoneOffset.UTC );
    System.out.println( "Zeit mit Offset (nur Offset verändert): " + changeTimeWithNewOffset );

    System.out.println( "Auch OffsetTime Objekte können verändert werden: "
            + changeTimeWithNewOffset.withHour( 3 ).plusSeconds( 2 ) );
  }

  public static void periods() {
    Period period = Period.of( 3, 2, 1 );
    System.out.println( "Zeitraum: " + period );

    LocalDate date = LocalDate.now();
    System.out.println( "Aktuelles Datum: " + date );

    LocalDate newDate = date.plus( period );
    System.out.println( "Neues Datum: " + newDate );

    ZonedDateTime zDateTime = ZonedDateTime.now();
    System.out.println( "Zeit (hier und jetzt): " + zDateTime );

    ZonedDateTime oldZDateTime = zDateTime.minus( period );
    System.out.println( "Zeit (hier und alt): " + oldZDateTime );

    System.out.println( "Zeitraum (Tage): " + period.get( ChronoUnit.DAYS ) );
  }

  public static void durations() {
    Duration duration = Duration.ofSeconds( 3, 5 );
    System.out.println( "Dauer: " + duration );

    Duration oneDay = Duration.between( LocalDateTime.now(), LocalDateTime.now().minus( 1, ChronoUnit.DAYS ) );
    System.out.println( "1 Tag:" + oneDay );

    System.out.println( "2 Tage: " + Duration.ofDays( 2 ) );
  }

  public static void kompatibilitaet() {
    Date date = new Date();
    System.out.println( "Altes Datum: " + date );
    System.out.println( "in Sekunden: " + date.getTime() );

    LocalDateTime test = LocalDateTime.ofEpochSecond( date.getTime() / 1000,
            (int) ( date.getTime() % 1000 * 1000 ), ZoneOffset.ofHours( 2 ) );
    System.out.println( "Neues Datum: " + test );
    System.out.println( "in Sekunden: " + test.toEpochSecond( ZoneOffset.ofHours( 2 ) ) );
  }
}
