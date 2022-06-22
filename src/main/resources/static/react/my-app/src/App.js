
import './App.css';
import {useState} from 'react';
import axios from "axios"

function App() {
  
  const [newfinance, setfinance] = useState("");
  const [amount, setAmount] = useState("");
  const [tenure, setTenure] = useState("");
  const [Idue , setIdue ] = useState("");
  const [Installment , dueInstallment ] = useState("");
  const [Advance, setAdvance] = useState("");
  const [Finance, setFinance] = useState("");
  const [Stagee, setStage] = useState("");
  const [rate, setrate] = useState("");
  const [IStage , dueSItage ] = useState("");
  const [Damount, setDamount] = useState("");
  const [DisbursementDate, setDisbursementDate] = useState("");
  const [InstallmentF, setInstallmentF] = useState("");
  const [Repayment , setRepayment ] = useState("");
  const [OpenDate , setOpenDate ] = useState("");
  const [Daycount , setDaycount ] = useState("");
  
  async function hel(e) {
		e.preventDefault()
		try {
			await axios.post("http://localhost:5000/api", {
				tenure
			})
		} catch (error) {
			console.error(error)
		}
	}
  
  return (
    <div className="App">
      <h1>Retail DDA Team</h1>
   <div className="info"></div>
  
  <form>
     
      
    <div className="contentform">
      


      <div className="leftcontact">
            <div className="form-group">
              <p>Finance Type<span>*</span></p>
              <span className="icon-case"><i className="fa fa-male"></i></span>
                <input type="text" name="nom" id="nom" data-rule="required" data-msg="Missing data"  value={newfinance}
            onChange={(e) => setfinance(e.target.value)}/>
                <div className="validation"></div>
       </div> 

            <div className="form-group">
            <p>Amount<span>*</span></p>
            <span className="icon-case"><i className="fa fa-user"></i></span>
        <input type="text" name="prenom" id="prenom" data-rule="required" data-msg="Missing data" value={amount}
            onChange={(e) => setAmount(e.target.value)}/>
                <div className="validation"></div>
      </div>

      <div className="form-group">
      <p>Tenure<span>*</span></p>  
      <span className="icon-case"><i className="fa fa-envelope-o"></i></span>
                <input type="text" name="email" id="email" data-rule="text" data-msg="Missing data." value={tenure}
            onChange={(e) => setTenure(e.target.value)}/>
                <div className="validation"></div>
      </div>  

      <div className="form-group">
      <p>Due Date on<span>*</span></p>
      <span className="icon-case"><i className="fa fa-home"></i></span>
        <input type="text" name="society" id="society" data-rule="required" data-msg="Missing data" value={Idue}
            onChange={(e) => setIdue(e.target.value)}/>
                <div className="validation"></div>
      </div>

      <div className="form-group">
      <p>Installment Computation Formula <span>*</span></p>
      <span className="icon-case"><i className="fa fa-location-arrow"></i></span>
        <input type="text" name="adresse" id="adresse" data-rule="required" data-msg="Missing data" value={Installment}
            onChange={(e) => dueInstallment(e.target.value)}/>
                <div className="validation"></div>
      </div>
      <div className="form-group">
      <p>Advance / Arrears<span>*</span></p>
      <span className="icon-case"><i className="fa fa-location-arrow"></i></span>
        <input type="text" name="adresse" id="adresse" data-rule="required" data-msg="Missing data" value={Advance}
            onChange={(e) => setAdvance(e.target.value)}/>
                <div className="validation"></div>
      </div>
      <div className="form-group">
      <p>Finance Fees<span>*</span></p>
      <span className="icon-case"><i className="fa fa-location-arrow"></i></span>
        <input type="text" name="adresse" id="adresse" data-rule="required" data-msg="Missing data" value={Finance}
            onChange={(e) => setFinance(e.target.value)}/>
                <div className="validation"></div>
      </div>

      <div className="form-group">
      <p>Stage Based Schedule<span>*</span></p>
      <span className="icon-case"><i className="fa fa-map-marker"></i></span>
        <input type="text" name="postal" id="postal" data-rule="required" data-msg="Missing data" value={Stagee}
            onChange={(e) => setStage(e.target.value)}/>
                <div className="validation"></div>
      </div>  



  </div>

  <div className="rightcontact">  

      <div className="form-group">
      <p>Day Count Convention<span>*</span></p>
      <span className="icon-case"><i className="fa fa-building-o"></i></span>
        <input type="text" name="ville" id="ville" data-rule="required" data-msg="Missing data" value={Daycount}
            onChange={(e) => setDaycount(e.target.value)} />
                <div className="validation"></div>
      </div>  

      <div className="form-group">
      <p>Account Open Date<span>*</span></p>  
      <span className="icon-case"><i className="fa fa-phone"></i></span>
        <input type="text" name="phone" id="phone" data-rule="maxlen:10" data-msg="Missing data" value={Repayment}
            onChange={(e) => setRepayment(e.target.value)}/>
                <div className="validation"></div>
      </div>

      <div className="form-group">
      <p>First Repayment after Disbursement<span>*</span></p>
      <span className="icon-case"><i className="fa fa-info"></i></span>
                <input type="text" name="fonction" id="fonction" data-rule="required" data-msg="Missing data" value={IStage}
            onChange={(e) => dueSItage(e.target.value)}/>
                <div className="validation"></div>
      </div>

      <div className="form-group">
      <p>	Installment Frequency<span>*</span></p> 
      <span className="icon-case"><i className="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data." value={InstallmentF}
            onChange={(e) => setInstallmentF(e.target.value)}/>
                <div className="validation"></div>
      </div>
      <div className="form-group">
      <p>	Disbursement Date<span>*</span></p> 
      <span className="icon-case"><i className="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data."value={OpenDate}
            onChange={(e) => setOpenDate(e.target.value)} />
                <div className="validation"></div>
      </div>
      <div className="form-group">
      <p>Disbursement Amount<span>*</span></p> 
      <span className="icon-case"><i className="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data." value={Damount}
            onChange={(e) => setDamount(e.target.value)}/>
                <div className="validation"></div>Damount
      </div>
      <div className="form-group">
      <p>	Disbursement Segment Number<span>*</span></p> 
      <span className="icon-case"><i className="fa fa-comment-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data." value={DisbursementDate}
            onChange={(e) => setDisbursementDate(e.target.value)}/>
                <div className="validation"></div>
      </div>
    
      <div className="form-group">
      <p>	Interest Rate<span>*</span></p>
      <span className="icon-case"><i className="fa fa-comments-o"></i></span>
                <input type="text" name="sujet" id="sujet" data-rule="required" data-msg="Missing data." value={rate}
            onChange={(e) => setrate(e.target.value)}/>
                <div className="validation"></div>
      </div>  
  </div>
  </div>
<button onClick={hel} type="submit" className="bouton-contact" >Send</button>
  
</form> 
    </div>
  );
}

export default App;
