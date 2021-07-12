/**
 * Beliebig viele Clients.<br>
 * Nachrichten der Clients werden in ChatRoom gegeben.<br>
 * ChatRoom leitet Nachricht per Observer-Muster an alle Clients weiter.<br>
 * Client sendet einen Namen mit (bei jeder Nachricht).<br>
 * Server schickt nach dem Verbinden den kompletten Nachrichtenverlauf an den
 * neuen Nutzer.
 */
package chat.stufe3_2;