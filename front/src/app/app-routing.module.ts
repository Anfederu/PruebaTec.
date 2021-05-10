import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ListarformsComponent } from './listarforms/listarforms.component';
import { AppComponent } from './app.component'
const routes: Routes = [
  { path: '', component: AppComponent },
  { path: '/login', component: LoginComponent },
  { path: '/list', component: ListarformsComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
