import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {

  form:FormGroup;
  constructor(private formBuilder:FormBuilder, private ruta:Router) {
    this.form = formBuilder.group(
      {
        email:['',[Validators.required, Validators.email]],
        password:['',[Validators.required, Validators.minLength(8)]],
        deviceInfo:this.formBuilder.group({
          deviceId:["eliddeldispositivo"],
          deviceType: ["DEVICE_TYPE_ANDROID"],
          notificationToken:["eltoquen"]
        })
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

  onSalir(event:Event)
  {
    event.preventDefault;
    this.ruta.navigate(['/portfolio']);
  }


}
