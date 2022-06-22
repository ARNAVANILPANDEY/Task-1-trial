import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <h1>Retail DDA Team</h1>
   <div class="info"></div>
  
  <form>
     
      
    <div class="contentform">
      


      <div class="leftcontact">
            <div class="form-group">
              <p>Finance Type<span>*</span></p>
              <span class="icon-case"><i class="fa fa-male"></i></span>
                <input type="text" name="nom" id="nom" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
       </div> 

            <div class="form-group">
            <p>Amount<span>*</span></p>
            <span class="icon-case"><i class="fa fa-user"></i></span>
        <input type="text" name="prenom" id="prenom" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>

      <div class="form-group">
      <p>Tenure<span>*</span></p>  
      <span class="icon-case"><i class="fa fa-envelope-o"></i></span>
                <input type="email" name="email" id="email" data-rule="email" data-msg="Missing data."/>
                <div class="validation"></div>
      </div>  

      <div class="form-group">
      <p>Due Date on<span>*</span></p>
      <span class="icon-case"><i class="fa fa-home"></i></span>
        <input type="text" name="society" id="society" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>

      <div class="form-group">
      <p>Installment Computation Formula <span>*</span></p>
      <span class="icon-case"><i class="fa fa-location-arrow"></i></span>
        <input type="text" name="adresse" id="adresse" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>
      <div class="form-group">
      <p>Advance / Arrears<span>*</span></p>
      <span class="icon-case"><i class="fa fa-location-arrow"></i></span>
        <input type="text" name="adresse" id="adresse" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>
      <div class="form-group">
      <p>Finance Fees<span>*</span></p>
      <span class="icon-case"><i class="fa fa-location-arrow"></i></span>
        <input type="text" name="adresse" id="adresse" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>

      <div class="form-group">
      <p>Stage Based Schedule<span>*</span></p>
      <span class="icon-case"><i class="fa fa-map-marker"></i></span>
        <input type="text" name="postal" id="postal" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>  



  </div>

  <div class="rightcontact">  

      <div class="form-group">
      <p>Day Count Convention<span>*</span></p>
      <span class="icon-case"><i class="fa fa-building-o"></i></span>
        <input type="text" name="ville" id="ville" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>  

      <div class="form-group">
      <p>Account Open Date<span>*</span></p>  
      <span class="icon-case"><i class="fa fa-phone"></i></span>
        <input type="text" name="phone" id="phone" data-rule="maxlen:10" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>

      <div class="form-group">
      <p>First Repayment after Disbursement<span>*</span></p>
      <span class="icon-case"><i class="fa fa-info"></i></span>
                <input type="text" name="fonction" id="fonction" data-rule="required" data-msg="Missing data"/>
                <div class="validation"></div>
      </div>

      <div class="form-group">
      <p>	Installment Frequency<span>*</span></p> 
      <span class="icon-case"><i class="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data."/>
                <div class="validation"></div>
      </div>
      <div class="form-group">
      <p>	Disbursement Date<span>*</span></p> 
      <span class="icon-case"><i class="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data."/>
                <div class="validation"></div>
      </div>
      <div class="form-group">
      <p>Disbursement Amount<span>*</span></p> 
      <span class="icon-case"><i class="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data."/>
                <div class="validation"></div>
      </div>
      <div class="form-group">
      <p>	Disbursement Segment Number<span>*</span></p> 
      <span class="icon-case"><i class="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data."/>
                <div class="validation"></div>
      </div>
    
      <div class="form-group">
      <p>	Interest Rate<span>*</span></p>
      <span class="icon-case"><i class="fa fa-comments-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data."/>
                <div class="validation"></div>
      </div>  
  </div>
  </div>
<button type="submit" class="bouton-contact">Send</button>
  
</form> 
    </div>
  );
}

export default App;
