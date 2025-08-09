import Shared
import SwiftUI

struct ContentView: View {
    let calculator = Calculator.Companion()
    let greet = Greeting().greeting()
    
    @State private var firstNum: String = "0"
    @State private var secondNum: String = "0"
    private var sum: String {
        if let firstNum = Int32(firstNum), let secondNum = Int32(secondNum) {
            return String(calculator.sum(a: firstNum, b: secondNum))
        } else {
            return "🤔"
        }
    }
    
    var body: some View {
        VStack(alignment: .center) {
            Text(greet)
            HStack(alignment: .center) {
                if #available(iOS 16.0, *) {
                    TextField("A", text: $firstNum, axis: .vertical)
                        .keyboardType(.numberPad)
                        .multilineTextAlignment(.center)
                        .frame(width: 30)
                } else {
                    TextEditor(text: $firstNum)
                        .keyboardType(.numberPad)
                        .frame(minWidth: 30)
                        .fixedSize(horizontal: true, vertical: true)
                }
                Text("+")
                if #available(iOS 16.0, *) {
                    TextField("B", text: $secondNum, axis: .vertical)
                        .keyboardType(.numberPad)
                        .multilineTextAlignment(.center)
                        .frame(width: 30)
                } else {
                    TextEditor(text: $secondNum)
                        .keyboardType(.numberPad)
                        .frame(minWidth: 30)
                        .fixedSize(horizontal: true, vertical: true)
                }
                Text("=")
                Text(sum)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
