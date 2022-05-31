import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form:FormGroup;
  constructor(private formBuilder:FormBuilder, private ruta:Router, private loginService:LoginService) {
    this.form = formBuilder.group(
      {
        email:['',[Validators.required, Validators.email]],
        password:['',[Validators.required, Validators.minLength(8)]]/*,
        deviceInfo:this.formBuilder.group({
          deviceId:["eliddeldispositivo"],
          deviceType: ["DEVICE_TYPE_ANDROID"],
          notificationToken:["eltoquen"]
        })*/
      })
    }

  ngOnInit(): void {
  }

  get Email()
  {
    return this.form.get('email');
  }

  get Password()
  {
    return this.form.get('password');
  }

  onEnviar(event:Event)
  {
    event.preventDefault;
    this.loginService.Login(this.form.value).subscribe(data=>{
      console.log("DATA" + JSON.stringify(data))});
      this.ruta.navigate(['/portfolio']);
  }

  onSalir() {
    this.ruta.navigate(['/portfolio']);  /* ME QUEDE EN ESTA PARTE DEL VIDEO DE LA PROFE*/
  }


}
