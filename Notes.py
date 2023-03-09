from tkinter import *
from tkinter import messagebox
from tkinter.filedialog import askopenfile, asksaveasfile

file_name=NONE

def new_file():
    global file_name
    file_name = "Untitled"
    text.delete('1.0', END)

def save_as():
    out = asksaveasfile(mode='w', defaultextension='.txt')
    data = text.get('1.0', END)
    try:
        out.write(data.rstrip())
    except Exception:
        messagebox.showerror("Can't save file!", "Try to use other filename")

def open_file():
    global file_name
    inp = askopenfile(mode='r')
    if inp is None:
        return
        file_name = inp.name
    data = inp.read()
    text.delete('1.0', END)
    text.insert('1.0', data)

root = Tk()
root.title("Notes")
root.geometry("600x400")

text = Text(root, width=400, height=400)
text.pack()

menu_bar = Menu(root)
file_menu = Menu(menu_bar)

file_menu.add_command(label='New file', command=new_file)
file_menu.add_command(label='Open', command=open_file)
file_menu.add_command(label='Save as', command=save_as)
file_menu.add_command(label='Exit', command=exit)



menu_bar.add_cascade(label="File", menu=file_menu)

root.config(menu=menu_bar)


root.mainloop()
