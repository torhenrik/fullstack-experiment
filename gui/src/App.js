import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header" />

  <div className="content">
  <h1 className="heading">
    Kjøp bilforsikring
  </h1>
  <p>
    Det er fire forskjellige forsikringer å velge mellom.  Ansvarsforsikring er 
    lovpålagt om kjøretøyet er registrert og skal brukes på veien.  I tillegg kan
    du utvide forsikringen avhengig av hvor gammel bilen er og hvordan
    du bruker den.
  </p>

  <form>

    <label>
      Bilens registreringsnummer:
      <input type="text" placeholder="e.g. AB 12345"/>
      <div class="helptext">Skriv et gyldig registreringsnummer.</div>
    </label>

    <label>
      Din bonus:
      <select>
        <option value=""></option>
        <option value="A">Lav</option>
        <option value="B">Medium</option>
        <option value="C">Høy</option>
      </select>
    </label>

    <label>
      Fødselsnummer:
      <input type="text" placeholder="11 siffer"/>
      <div class="helptext">Et personnummer består av 11 siffer</div>
    </label>

    <label id="firstname">
      Fornavn:
      <input type="text" placeholder="Placeholder"/>
      <div class="helptext">Fornavn må fylles ut.</div>
    </label>
    
    <label id="surname">
      Etternavn:
      <input type="text" placeholder="Placeholder"/>
      <div class="helptext">Etternavn må fylles ut.</div>
    </label>

    <label>
      Epost:
      <input type="text" placeholder="Placeholder"/>
      <div class="helptext">Skriv inn en gyldig epostaddresse.</div>
    </label>

    <div>
    <input type="submit" class="btn" value="Kjøp" />
    <input type="reset" class="btn" value="Avbryt" />
    </div>

  </form>
  </div>
  </div>
  );
}

export default App;
