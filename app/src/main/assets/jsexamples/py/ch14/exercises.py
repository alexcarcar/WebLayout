import os

# Exercise 14-1
def walk2(dirname):
    """Prints the names of all files in dirname and its subdirectories.
    dirname: string name of directory
    """
    for root, dirs, files in os.walk(dirname):
        for filename in files:
            print os.path.join(root, filename)
walk2(".")
# .\examples.py
# .\exercises.py
# .\index.html
# .\output.txt

# Exercise 14-2
def sed(pattern, replace, source, dest):
    """Reads a source file and writes the destination file.
    In each line, replaces pattern with replace.
    """
    try:
        fin = open(source, 'r')
        fout = open(dest, 'w')

        for line in fin:
            line = line.replace(pattern, replace)
            fout.write(line)

        fin.close()
        fout.close()
    except:
        print 'Something went wrong.'

sed('2', 'two', 'output.txt', 'output2.txt')
f = open('output2.txt')
for line in f:print line.strip()
f.close()
# 5two
sed('2', 'two', 'bad_file', 'output2.txt')
# Something went wrong.