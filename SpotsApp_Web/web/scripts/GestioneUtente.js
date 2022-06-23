function requestInterestIframe() {
	// qui faccio scaricare al browser direttamente il contenuto del feed come src dell'iframe.
	Alert("Impossibile effettuare l'operazione, il tuo browser è troppo vecchio")
	
	// non riesco tuttavia a intervenire per parsificarlo! è il browser che renderizza il src del iframe!
}

function requestAJAX(xhr, val) {
	// impostazione controllo e stato della richiesta
	// xhr.onreadystatechange = function() { callback(xhr); };
	// impostazione richiesta asincrona in GET
	// del file specificato
	try {
		xhr.open("get", "gestioneUtente?operazione="+val+"&idSpot="+idSpot, true);
	}
	catch(e) {
		// Exceptions are raised when trying to access cross-domain URIs
		alert(e);
	}
	// rimozione dell'header "connection" come "keep alive"
	xhr.setRequestHeader("connection", "close");
	// invio richiesta
	xhr.send(null);
} 

function visualizzaSpot(myB)
{
	var xhr = myGetXmlHttpRequest();
	var val=myB.value;
	
	if ( xhr ) 
		requestAJAX(xhr, val);
	else 
		requestInterestIframe();
}

function aggiungiSpot(myB)
{
	var xhr = myGetXmlHttpRequest();
	var val=myB.value;
	
	if ( xhr ) 
		requestAJAX(xhr, val);
	else 
		requestInterestIframe();
}

function visualizzaProfilo(myB)
{
	var xhr = myGetXmlHttpRequest();
	var val=myB.value;
	
	if ( xhr ) 
		requestAJAX(xhr, val);
	else 
		requestInterestIframe();
}

function logout(myB)
{
	var xhr = myGetXmlHttpRequest();
	var val=myB.value;
	
	if ( xhr ) 
		requestAJAX(xhr, val);
	else 
		requestInterestIframe();
}