# App Bancário Teste
    Aplicativo de exemplo feito em Kotlin com Jetpack Compose, seguindo o padrão MVVM.
    O app realiza login de usuário e navegação entre telas, com persistência de dados local via DataStore e testes unitários.

 ## 🛠️ Tecnologias Utilizadas
    Kotlin
    Jetpack Compose
    MVVM com ViewModel e StateFlow
    Retrofit + Coroutines para chamadas de API
    Navigation Compose para navegação entre telas
    Material Design 3 (Theme padrão)
    Layout responsivo
    DataStore para guardar dados do usuário após login
    Testes Unitários com MockK e Coroutines Test

## 📦 Funcionalidades
    Tela de login com preenchimento automático se houver dados salvos
    Navegação para tela de detalhes do pagamento após login
    Persistência local de email e senha via DataStore
    Limpeza de dados ao deslogar
    Testes unitários cobrindo ViewModel e DataStore

## 🚀 Como Rodar
    Clone o repositório:
    git clone <URL_DO_REPOSITORIO>
    Abra o projeto no Android Studio (recomendado Arctic Fox ou superior)
    Sincronize o Gradle
    Execute no emulador ou dispositivo físico

## 🧪 Testes
    O projeto possui testes unitários cobrindo:
    Recuperação de dados do usuário via LoginViewModel
    Salvamento e leitura de dados com DataStoreUtil
    Estados de sucesso, erro e idle
    Para rodar os testes:
    ./gradlew test

## 🔧 Observações
    O login simula integração com um repositório/serviço fictício (UserRepository)
    O DataStore é usado apenas para persistência local de login
    O projeto segue boas práticas de Clean Architecture e Jetpack Compose