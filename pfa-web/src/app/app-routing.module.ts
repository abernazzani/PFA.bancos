import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { LayoutComponent } from './shared/components/layout/layout.component';


const routes: Routes = [
  { path: '', redirectTo: 'asaltos', pathMatch: 'full' },
  {
    path: 'login', loadChildren: () => import('./modules/login/login.module').then(m => m.LoginModule),
  },
  {
    path: 'bancos', loadChildren: () => import('./modules/entidades-bancarias/entidades-bancarias.module').then(m => m.BancosModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'bandas', loadChildren: () => import('./modules/bandas/bandas.module').then(m => m.BandasModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'jueces', loadChildren: () => import('./modules/jueces/jueces.module').then(m => m.JuecesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'delincuentes', loadChildren: () => import('./modules/delincuentes/delincuentes.module').then(m => m.DelincuentesModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'asaltos', loadChildren: () => import('./modules/asaltos/asaltos.module').then(m => m.AsaltosModule),
    // canActivate: [AuthGuard]
  },
  {
    path: 'contrataciones', loadChildren: () => import('./modules/contrataciones/contrataciones.module').then(m =>  m.ContratacionesModule),
    
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
