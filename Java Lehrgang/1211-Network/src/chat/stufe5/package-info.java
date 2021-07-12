/**
 * Beliebig viele Clients.<br>
 * Nachrichten der Clients werden in ChatRoom gegeben.<br>
 * ChatRoom leitet Nachricht per Observer-Muster an alle Clients weiter.<br>
 * Client sendet einen Namen mit (bei jeder Nachricht).<br>
 * Server schickt nach dem Verbinden den kompletten Nachrichtenverlauf an den neuen Nutzer.<br>
 * Server verteilt per Multicast seine IP und den Port.<br>
 * Nachrichten werden in DB gespeichert und bei Neustart wieder eingelesen.
 */
package chat.stufe5;
