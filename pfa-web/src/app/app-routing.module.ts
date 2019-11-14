import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AsaltosComponent } from './components/asaltos/asaltos/asaltos.component';


const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path: "asaltos", component: AsaltosComponent },
  { path: "**", redirectTo: "home" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
